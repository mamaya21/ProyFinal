package com.nttdata.bootcamp.msyanki.repository;

import java.util.UUID;
import com.nttdata.bootcamp.msyanki.domain.Yanki;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor

public class YankiRepository {

    private final ReactiveRedisOperations<String, Yanki> reactiveRedisOperations;

    public Mono<Yanki> save(Yanki data) {
        return this.reactiveRedisOperations.<String, Yanki>opsForHash()
                .put("yanki", data.getId(), data).log().map(p -> data);
    }

    public Flux<Yanki> findAll() {
        return this.reactiveRedisOperations.<String, Yanki>opsForHash().values("yanki");
    }

    public Mono<Yanki> findById(String id) {
        return this.reactiveRedisOperations.<String, Yanki>opsForHash().get("yanki", id);
    }

}
