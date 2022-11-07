package com.nttdata.bootcamp.msyanki.web;

import com.nttdata.bootcamp.msyanki.service.PagoYankiService;
import com.nttdata.bootcamp.msyanki.service.YankiService;
import com.nttdata.bootcamp.msyanki.web.maper.PagoYankiMapper;
import com.nttdata.bootcamp.msyanki.web.maper.YankiMapper;
import com.nttdata.bootcamp.msyanki.web.model.PagoYankiModel;
import com.nttdata.bootcamp.msyanki.web.model.YankiModel;
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
@RequestMapping("/v1/pagoyanking")


public class PagoYankiController {

    @Value("${spring.application.name}")
    String name;

    @Value("${server.port}")
    String port;


    @Autowired
    private PagoYankiService pagoYankiService;

    @Autowired
    private PagoYankiMapper pagoYankiMapper;

    @PostMapping
    public Mono<ResponseEntity<PagoYankiModel>> createPago(@Valid @RequestBody PagoYankiModel request){
        log.info("create executed {}", request);
        return pagoYankiService.create(pagoYankiMapper.modelToEntity(request))
                .map(catalog -> pagoYankiMapper.entityToModel(catalog))
                .flatMap(c -> Mono.just(ResponseEntity.created(URI.create(String.format("http://%s:%s/%s/%s", name, port, "PagoYanki", c.getId())))
                        .body(c)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Mono<ResponseEntity<Flux<PagoYankiModel>>>  getAllPago(){
        log.info("getAll executed");

        return Mono.just(ResponseEntity.ok()
                .body(pagoYankiService.findAll()
                        .map(catalog -> pagoYankiMapper.entityToModel(catalog))));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<PagoYankiModel>> getByIdPago(@PathVariable String id){
        log.info("getById executed {}", id);
        return pagoYankiService.findById(id)
                .map(catalog -> pagoYankiMapper.entityToModel(catalog))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public Mono<ResponseEntity<Flux<PagoYankiModel>>> getByNamePago(@PathVariable String name){
        log.info("getByName executed {}", name);
        return Mono.just(ResponseEntity.ok()
                .body(pagoYankiService.findByName(name)
                        .map(catalog -> pagoYankiMapper.entityToModel(catalog))));
    }



    @PutMapping("/{id}")
    public Mono<ResponseEntity<PagoYankiModel>> updateByIdPago(@PathVariable String id, @Valid @RequestBody PagoYankiModel request){
        log.info("updateById executed {}:{}", id, request);
        return pagoYankiService.update(id, pagoYankiMapper.modelToEntity(request))
                .map(catalog -> pagoYankiMapper.entityToModel(catalog))
                .flatMap(c -> Mono.just(ResponseEntity.created(URI.create(String.format("http://%s:%s/%s/%s", name, port, "PagoYanki", c.getId())))
                        .body(c)))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteByIdPago(@PathVariable String id){
        log.info("deleteById executed {}", id);
        return pagoYankiService.delete(id)
                .map( r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
