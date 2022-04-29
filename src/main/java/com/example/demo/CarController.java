package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
@SchemaMapping(typeName="Car")
public class CarController {

    @Autowired
    CarService carService;

    @QueryMapping
    public Mono<List<Car>> cars() {
        return carService.getCars();
    }

}
