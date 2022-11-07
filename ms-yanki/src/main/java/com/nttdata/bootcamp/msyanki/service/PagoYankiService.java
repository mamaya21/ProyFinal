package com.nttdata.bootcamp.msyanki.service;

import com.nttdata.bootcamp.msyanki.domain.PagoYanki;
import com.nttdata.bootcamp.msyanki.domain.Yanki;
import com.nttdata.bootcamp.msyanki.repository.PagoYankiRepository;
import com.nttdata.bootcamp.msyanki.repository.YankiRepository;
import com.nttdata.bootcamp.msyanki.web.maper.PagoYankiMapper;
import com.nttdata.bootcamp.msyanki.web.maper.YankiMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional

public class PagoYankiService {

    @Autowired
    private PagoYankiRepository catalogRepository;

    @Autowired
    private PagoYankiMapper yankiMapper;


    public Mono<PagoYanki> create(PagoYanki parameter){
        log.debug("create executed {}", parameter);
        return catalogRepository.save(parameter);
    }

    public Flux<PagoYanki> findAll(){
        log.debug("findAll executed");
        return catalogRepository.findAll();
    }

    public Mono<PagoYanki> findById(String catalogId){
        log.debug("findById executed {}", catalogId);
        return catalogRepository.findById(catalogId);
    }

    public Flux<PagoYanki> findByName(String parameter){
        log.debug("findByName executed {}", parameter);
        return catalogRepository.findByParameter(parameter);
    }

    public Mono<PagoYanki> update(String parameterId,  PagoYanki parameter){
        log.debug("update executed {}:{}", parameterId, parameter);
        return catalogRepository.findById(parameterId)
                .flatMap(dbparameter -> {
                    yankiMapper.update(dbparameter, parameter);
                    return catalogRepository.save(dbparameter);
                });
    }

    public Mono<PagoYanki> delete(String parameterId){
        log.debug("delete executed {}", parameterId);
        return catalogRepository.findById(parameterId)
                .flatMap(existingparameter -> catalogRepository.delete(existingparameter)
                        .then(Mono.just(existingparameter)));
    }

}
