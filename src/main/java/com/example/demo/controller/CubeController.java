package com.example.demo.controller;

import com.example.demo.model.CubeDto;
import com.example.demo.service.CubeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cube")
public class CubeController {

    private final CubeService cubeService;

    @PostMapping
    public Mono<CubeDto> saveCube(@RequestBody CubeDto cubeDto) {
        return cubeService.saveCube(cubeDto);
    }
}
