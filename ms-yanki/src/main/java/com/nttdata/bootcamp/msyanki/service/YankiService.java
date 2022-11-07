package com.nttdata.bootcamp.msyanki.service;

import com.nttdata.bootcamp.msyanki.domain.Yanki;
import com.nttdata.bootcamp.msyanki.repository.YankiRepository;
import com.nttdata.bootcamp.msyanki.web.maper.YankiMapper;
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

public class YankiService {

    @Autowired
    private YankiRepository catalogRepository;

    @Autowired
    private YankiMapper yankiMapper;


    public Mono<Yanki> create(Yanki parameter){
        log.debug("create executed {}", parameter);
        return catalogRepository.save(parameter);
    }

    public Flux<Yanki> findAll(){
        log.debug("findAll executed");
        return catalogRepository.findAll();
    }

    public Mono<Yanki> findById(String catalogId){
        log.debug("findById executed {}", catalogId);
        return catalogRepository.findById(catalogId);
    }

}
