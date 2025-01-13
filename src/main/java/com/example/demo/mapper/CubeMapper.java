package com.example.demo.mapper;

import com.example.demo.model.Cube;
import com.example.demo.model.CubeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CubeMapper {
    CubeDto toCubeDto(Cube cube);
    Cube toCube(CubeDto cubeDto);
}
