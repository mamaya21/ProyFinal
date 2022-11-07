package com.nttdata.bootcamp.msp2p.web;

import com.nttdata.bootcamp.msp2p.service.PagoP2PService;
import com.nttdata.bootcamp.msp2p.web.maper.PagoP2PMapper;
import com.nttdata.bootcamp.msp2p.web.model.PagoP2PModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/pagobootcoin")


public class PagoP2PController {

    @Value("${spring.application.name}")
    String name;

    @Value("${server.port}")
    String port;


    @Autowired
    private PagoP2PService pagoP2PService;

    @Autowired
    private PagoP2PMapper pagoP2PMapper;

    @PostMapping
    public Mono<ResponseEntity<PagoP2PModel>> createPago(@Valid @RequestBody PagoP2PModel request){
        log.info("create executed {}", request);
        return pagoP2PService.create(pagoP2PMapper.modelToEntity(request))
                .map(catalog -> pagoP2PMapper.entityToModel(catalog))
                .flatMap(c -> Mono.just(ResponseEntity.created(URI.create(String.format("http://%s:%s/%s/%s", name, port, "PagoYanki", c.getId())))
                        .body(c)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Mono<ResponseEntity<Flux<PagoP2PModel>>>  getAllPago(){
        log.info("getAll executed");

        return Mono.just(ResponseEntity.ok()
                .body(pagoP2PService.findAll()
                        .map(catalog -> pagoP2PMapper.entityToModel(catalog))));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<PagoP2PModel>> getByIdPago(@PathVariable String id){
        log.info("getById executed {}", id);
        return pagoP2PService.findById(id)
                .map(catalog -> pagoP2PMapper.entityToModel(catalog))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public Mono<ResponseEntity<Flux<PagoP2PModel>>> getByNamePago(@PathVariable String name){
        log.info("getByName executed {}", name);
        return Mono.just(ResponseEntity.ok()
                .body(pagoP2PService.findByName(name)
                        .map(catalog -> pagoP2PMapper.entityToModel(catalog))));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<PagoP2PModel>> updateByIdPago(@PathVariable String id, @Valid @RequestBody PagoP2PModel request){
        log.info("updateById executed {}:{}", id, request);
        return pagoP2PService.update(id, pagoP2PMapper.modelToEntity(request))
                .map(catalog -> pagoP2PMapper.entityToModel(catalog))
                .flatMap(c -> Mono.just(ResponseEntity.created(URI.create(String.format("http://%s:%s/%s/%s", name, port, "PagoYanki", c.getId())))
                        .body(c)))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteByIdPago(@PathVariable String id){
        log.info("deleteById executed {}", id);
        return pagoP2PService.delete(id)
                .map( r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
