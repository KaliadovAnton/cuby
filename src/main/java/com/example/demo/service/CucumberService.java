package com.example.demo.service;

import com.example.demo.model.Cucumber;
import com.example.demo.model.Jar;
import reactor.core.publisher.Flux;

public interface CucumberService {
    Flux<Jar> putCucumbersInJar(Flux<Cucumber> cucumbers);
}
