package com.example.demo.service;

import com.example.demo.model.CubeDto;
import reactor.core.publisher.Mono;

public interface CubeService {

    Mono<CubeDto> saveCube(CubeDto cubeDto);

    Mono<CubeDto> findCube(String id);
}
