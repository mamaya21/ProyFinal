package com.nttdata.bootcamp.msp2p.repository;

import com.nttdata.bootcamp.msp2p.domain.PagoP2P;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
@RequiredArgsConstructor

public class PagoP2PRepository {

    private final ReactiveRedisOperations<String, PagoP2P> reactiveRedisOperations;

    public Mono<PagoP2P> save(PagoP2P data) {
        if (data.getId() == null) {
            String id = UUID.randomUUID().toString();
            data.setId(id);
        }
        return this.reactiveRedisOperations.<String, PagoP2P>opsForHash()
                .put("pagobootcoin", data.getId(), data).log().map(p -> data);
    }

    public Flux<PagoP2P> findAll() {
        return this.reactiveRedisOperations.<String, PagoP2P>opsForHash().values("pagobootcoin");
    }

    public Mono<PagoP2P> findById(String id) {
        return this.reactiveRedisOperations.<String, PagoP2P>opsForHash().get("pagobootcoin", id);
    }

    public Flux<PagoP2P> findByParameter(String parameter) {
        return this.findAll().filter(p -> p.getIdBuyer().equals(parameter));
    }

    public Mono<Boolean> deleteAll() {
        return this.reactiveRedisOperations.<String, PagoP2P>opsForHash().delete("pagobootcoin");
    }

    public Mono<PagoP2P> delete(PagoP2P parameter) {
        return this.reactiveRedisOperations.<String, PagoP2P>opsForHash().remove("pagobootcoin", parameter.getId())
                .flatMap(p -> Mono.just(parameter));
    }


}
