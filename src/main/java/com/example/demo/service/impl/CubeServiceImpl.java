package com.example.demo.service.impl;

import com.example.demo.mapper.CubeMapper;
import com.example.demo.model.CubeDto;
import com.example.demo.repository.CubeRepository;
import com.example.demo.service.CubeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CubeServiceImpl implements CubeService {

    private final CubeRepository cubeRepository;
    private final CubeMapper cubeMapper;

    @Override
    public Mono<CubeDto> saveCube(CubeDto cubeDto) {
        return cubeRepository.save(cubeMapper.toCube(cubeDto))
                .map(cubeMapper::toCubeDto);
    }

    @Override
    public Mono<CubeDto> findCube(String id) {
        return cubeRepository.findById(id).map(cubeMapper::toCubeDto);
    }
}
