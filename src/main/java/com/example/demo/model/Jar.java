package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jar {

    public Jar(Integer volume) {
        this.volume = volume;
    }

    private List<Cucumber> cucumbers;
    private Integer volume;
}
