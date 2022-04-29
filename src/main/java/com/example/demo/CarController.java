package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
@SchemaMapping(typeName="Car")
public class CarController {

    static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CarController.class);

    @Autowired
    CarService carService;

    @QueryMapping
    public Mono<List<Car>> cars() {
        return carService.getCars()
                .doFirst(() -> LOGGER.info("Fetching cars"))
                .doFinally((ignored) -> LOGGER.info("Finished fetching cars"));

    }

}
