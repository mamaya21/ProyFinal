package com.nttdata.bootcamp.msyanki.web;

import java.net.URI;

import javax.validation.Valid;

import com.nttdata.bootcamp.msyanki.service.YankiService;
import com.nttdata.bootcamp.msyanki.web.maper.YankiMapper;
import com.nttdata.bootcamp.msyanki.web.model.YankiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/v1/yanking")


public class YankiController {

    @Value("${spring.application.name}")
    String name;

    @Value("${server.port}")
    String port;


    @Autowired
    private YankiService yankiService;

    @Autowired
    private YankiMapper yankiMapper;

    @PostMapping
    public Mono<ResponseEntity<YankiModel>> create(@Valid @RequestBody YankiModel request){
        log.info("create executed {}", request);
        return yankiService.create(yankiMapper.modelToEntity(request))
                .map(catalog -> yankiMapper.entityToModel(catalog))
                .flatMap(c -> Mono.just(ResponseEntity.created(URI.create(String.format("http://%s:%s/%s/%s", name, port, "Yanki", c.getId())))
                        .body(c)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Mono<ResponseEntity<Flux<YankiModel>>>  getAll(){
        log.info("getAll executed");

        return Mono.just(ResponseEntity.ok()
                .body(yankiService.findAll()
                        .map(catalog -> yankiMapper.entityToModel(catalog))));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<YankiModel>> getById(@PathVariable String id){
        log.info("getById executed {}", id);
        return yankiService.findById(id)
                .map(catalog -> yankiMapper.entityToModel(catalog))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


}
