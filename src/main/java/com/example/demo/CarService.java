package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CarService {

    @Autowired
    WebClient webClient;

    // @NewSpan
    public Mono<List<Car>> getCars() {
        return webClient.get()
                .uri("cars")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});
        /**
         * Create external mock endpoint with rule for GET /cars which returns
         * response of [{"name":"red"},{"name":"blue"},{"name":"green"}]
         * https://beeceptor.com/console/cars1234
         */
    }
}
