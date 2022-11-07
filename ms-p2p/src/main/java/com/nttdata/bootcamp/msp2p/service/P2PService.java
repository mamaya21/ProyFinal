package com.nttdata.bootcamp.msp2p.service;

import com.nttdata.bootcamp.msp2p.domain.P2P;
import com.nttdata.bootcamp.msp2p.repository.P2PRepository;
import com.nttdata.bootcamp.msp2p.web.maper.P2PMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional

public class P2PService {

    @Autowired
    private P2PRepository catalogRepository;

    @Autowired
    private P2PMapper p2PMapper;


    public Mono<P2P> create(P2P parameter){
        log.debug("create executed {}", parameter);
        return catalogRepository.save(parameter);
    }

    public Flux<P2P> findAll(){
        log.debug("findAll executed");
        return catalogRepository.findAll();
    }

    public Mono<P2P> findById(String catalogId){
        log.debug("findById executed {}", catalogId);
        return catalogRepository.findById(catalogId);
    }

}
