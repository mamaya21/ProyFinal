package com.nttdata.bootcamp.mspersistence.application;

import com.nttdata.bootcamp.mspersistence.model.CustomerNatural;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("customernatural")
public class CustomerNaturalController {
    @Autowired
    CustomerNaturalService customerNaturalService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CustomerNatural> createCustomer(@RequestBody Mono<CustomerNatural> customer){
        return customerNaturalService.createCustomer(customer);
    }

    @GetMapping(value = "get")
    public Flux<CustomerNatural> listAll(){
        return customerNaturalService.listAll();
    }

    @GetMapping(value = "get/{id}")
    public Mono<CustomerNatural> listCustomerId(@PathVariable("id") Integer id){
        return customerNaturalService.listCustomerId(id);
    }

    @DeleteMapping(value = "delete/{id}")
    public Mono<Void> deleteCustomer(@PathVariable("id") Integer id){
        return customerNaturalService.deleteCustomer(id);
    }
}
