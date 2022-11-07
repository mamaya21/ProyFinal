package com.nttdata.bootcamp.msp2p.service;

import com.nttdata.bootcamp.msp2p.domain.PagoP2P;
import com.nttdata.bootcamp.msp2p.repository.PagoP2PRepository;
import com.nttdata.bootcamp.msp2p.web.maper.PagoP2PMapper;
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

public class PagoP2PService {

    @Autowired
    private PagoP2PRepository catalogRepository;

    @Autowired
    private PagoP2PMapper yankiMapper;


    public Mono<PagoP2P> create(PagoP2P parameter){
        log.debug("create executed {}", parameter);
        return catalogRepository.save(parameter);
    }

    public Flux<PagoP2P> findAll(){
        log.debug("findAll executed");
        return catalogRepository.findAll();
    }

    public Mono<PagoP2P> findById(String catalogId){
        log.debug("findById executed {}", catalogId);
        return catalogRepository.findById(catalogId);
    }

    public Flux<PagoP2P> findByName(String parameter){
        log.debug("findByName executed {}", parameter);
        return catalogRepository.findByParameter(parameter);
    }

    public Mono<PagoP2P> update(String parameterId, PagoP2P parameter){
        log.debug("update executed {}:{}", parameterId, parameter);
        return catalogRepository.findById(parameterId)
                .flatMap(dbparameter -> {
                    yankiMapper.update(dbparameter, parameter);
                    return catalogRepository.save(dbparameter);
                });
    }

    public Mono<PagoP2P> delete(String parameterId){
        log.debug("delete executed {}", parameterId);
        return catalogRepository.findById(parameterId)
                .flatMap(existingparameter -> catalogRepository.delete(existingparameter)
                        .then(Mono.just(existingparameter)));
    }

}
