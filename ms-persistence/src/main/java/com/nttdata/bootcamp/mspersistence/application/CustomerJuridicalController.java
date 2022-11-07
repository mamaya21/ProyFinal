package com.nttdata.bootcamp.mspersistence.application;

import com.nttdata.bootcamp.mspersistence.model.CustomerJuridical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("customerjuridical")

public class CustomerJuridicalController {

    @Autowired
    CustomerJuridicalService juridicalService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CustomerJuridical> createCustomer(@RequestBody Mono<CustomerJuridical> customer){
        return juridicalService.createCustomer(customer);
    }

    @GetMapping(value = "get")
    public Flux<CustomerJuridical> listAll(){
        return juridicalService.listAll();
    }

    @GetMapping(value = "get/{id}")
    public Mono<CustomerJuridical> listCustomerId(@PathVariable("id") Integer id){
        return juridicalService.listCustomerId(id);
    }

    @DeleteMapping(value = "delete/{id}")
    public Mono<Void> deleteCustomer(@PathVariable("id") Integer id){
        return juridicalService.deleteCustomer(id);
    }

}
