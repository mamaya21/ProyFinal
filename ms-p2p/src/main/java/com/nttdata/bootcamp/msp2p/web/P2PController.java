package com.nttdata.bootcamp.msp2p.web;

import java.net.URI;

import javax.validation.Valid;

import com.nttdata.bootcamp.msp2p.service.P2PService;
import com.nttdata.bootcamp.msp2p.web.maper.P2PMapper;
import com.nttdata.bootcamp.msp2p.web.model.P2PModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/bootcoin")


public class P2PController {

    @Value("${spring.application.name}")
    String name;

    @Value("${server.port}")
    String port;


    @Autowired
    private P2PService p2PService;

    @Autowired
    private P2PMapper p2PMapper;

    @PostMapping
    public Mono<ResponseEntity<P2PModel>> create(@Valid @RequestBody P2PModel request){
        log.info("create executed {}", request);
        return p2PService.create(p2PMapper.modelToEntity(request))
                .map(catalog -> p2PMapper.entityToModel(catalog))
                .flatMap(c -> Mono.just(ResponseEntity.created(URI.create(String.format("http://%s:%s/%s/%s", name, port, "Yanki", c.getId())))
                        .body(c)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Mono<ResponseEntity<Flux<P2PModel>>>  getAll(){
        log.info("getAll executed");

        return Mono.just(ResponseEntity.ok()
                .body(p2PService.findAll()
                        .map(catalog -> p2PMapper.entityToModel(catalog))));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<P2PModel>> getById(@PathVariable String id){
        log.info("getById executed {}", id);
        return p2PService.findById(id)
                .map(catalog -> p2PMapper.entityToModel(catalog))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


}
