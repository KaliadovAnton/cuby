package com.example.demo.service.impl;

import com.example.demo.model.Cucumber;
import com.example.demo.model.Jar;
import com.example.demo.service.CucumberService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;


public class CucumberServiceImpl implements CucumberService {

    private final Integer jarVolume = 3;
    private Jar currentJar = new Jar(new ArrayList<>(), 0);

    @Override
    public Flux<Jar> putCucumbersInJar(Flux<Cucumber> cucumbers) {
        Sinks.Many<Jar> jarSink = Sinks.many().multicast().onBackpressureBuffer();

        cucumbers.subscribe(cucumber -> {
            while (true) {
                if (currentJar.getVolume() >= jarVolume) {
                    jarSink.tryEmitNext(currentJar);
                    currentJar = new Jar(new ArrayList<>(), 0);
                }
                if (addCucumber(cucumber, currentJar)) {
                    break;
                }
            }
        }, e -> jarSink.tryEmitError(e), () -> {
            if (currentJar.getVolume() > 0) {
                jarSink.tryEmitNext(currentJar);
            }
            jarSink.tryEmitComplete();
        });

        return jarSink.asFlux();
    }

    public boolean addCucumber(Cucumber cucumber, Jar jar) {
        if (jar.getVolume() + cucumber.getVolume() <= jarVolume) {
            jar.getCucumbers().add(cucumber);
            jar.setVolume(jar.getVolume() + cucumber.getVolume());
            return true;
        } else {
            var cutCucumber = new Cucumber(jarVolume - currentJar.getVolume());
            jar.getCucumbers().add(cutCucumber);
            jar.setVolume(jar.getVolume() + cutCucumber.getVolume());
            cucumber.setVolume(cucumber.getVolume() - cutCucumber.getVolume());
        }
        return false;
    }
}
