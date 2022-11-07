package com.nttdata.bootcamp.msp2p.repository;

import com.nttdata.bootcamp.msp2p.domain.P2P;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor

public class P2PRepository {

    private final ReactiveRedisOperations<String, P2P> reactiveRedisOperations;

    public Mono<P2P> save(P2P data) {
        return this.reactiveRedisOperations.<String, P2P>opsForHash()
                .put("bootcoin", data.getId(), data).log().map(p -> data);
    }

    public Flux<P2P> findAll() {
        return this.reactiveRedisOperations.<String, P2P>opsForHash().values("bootcoin");
    }

    public Mono<P2P> findById(String id) {
        return this.reactiveRedisOperations.<String, P2P>opsForHash().get("bootcoin", id);
    }

}
