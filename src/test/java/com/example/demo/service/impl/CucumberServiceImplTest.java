package com.example.demo.service.impl;

import com.example.demo.model.Cucumber;
import com.example.demo.model.Jar;
import com.example.demo.service.CucumberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.List;

public class CucumberServiceImplTest {

    private CucumberService cucumberService = new CucumberServiceImpl();

    @Test
    public void testPutCucumbersPositive() {
        //given
        var cucumber1 = new Cucumber(1);
        var cucumber2 = new Cucumber(2);
        var cucumber3 = new Cucumber(3);
        var cucumber4 = new Cucumber(2);
        var cucumber5 = new Cucumber(2);
        var cucumbers = Flux.just(cucumber1, cucumber2, cucumber3, cucumber4, cucumber5);
        var jar1 = new Jar(List.of(cucumber1, cucumber2), 3);
        var jar2 = new Jar(List.of(cucumber3), 3);
        var jar3 = new Jar(List.of(cucumber4, new Cucumber(1)), 3);
        var jar4 = new Jar(List.of(new Cucumber(1)), 1);
        var expected = Flux.just(jar1, jar2, jar3, jar4).toStream().toList();
        //when
        var result = cucumberService.putCucumbersInJar(cucumbers).toStream().toList();
        //then
        Assertions.assertEquals(expected, result);
    }
}