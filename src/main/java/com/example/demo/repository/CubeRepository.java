package com.example.demo.repository;

import com.example.demo.model.Cube;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CubeRepository extends ReactiveMongoRepository<Cube, String> {
}
