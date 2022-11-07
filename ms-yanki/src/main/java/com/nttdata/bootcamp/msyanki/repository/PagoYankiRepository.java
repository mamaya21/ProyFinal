package com.nttdata.bootcamp.msyanki.repository;

import com.nttdata.bootcamp.msyanki.domain.PagoYanki;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
@RequiredArgsConstructor

public class PagoYankiRepository {

    private final ReactiveRedisOperations<String, PagoYanki> reactiveRedisOperations;

    public Mono<PagoYanki> save(PagoYanki data) {
        if (data.getId() == null) {
            String id = UUID.randomUUID().toString();
            data.setId(id);
        }
        return this.reactiveRedisOperations.<String, PagoYanki>opsForHash()
                .put("pagoyanki", data.getId(), data).log().map(p -> data);
    }

    public Flux<PagoYanki> findAll() {
        return this.reactiveRedisOperations.<String, PagoYanki>opsForHash().values("pagoyanki");
    }

    public Mono<PagoYanki> findById(String id) {
        return this.reactiveRedisOperations.<String, PagoYanki>opsForHash().get("pagoyanki", id);
    }

    public Flux<PagoYanki> findByParameter(String parameter) {
        return this.findAll().filter(p -> p.getIdReceiver().equals(parameter));
    }

    public Mono<Boolean> deleteAll() {
        return this.reactiveRedisOperations.<String, PagoYanki>opsForHash().delete("pagoyanki");
    }

    public Mono<PagoYanki> delete(PagoYanki parameter) {
        return this.reactiveRedisOperations.<String, PagoYanki>opsForHash().remove("pagoyanki", parameter.getId())
                .flatMap(p -> Mono.just(parameter));
    }


}
