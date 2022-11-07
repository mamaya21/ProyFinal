package com.nttdata.bootcamp.mscustomer.aplication;

import com.nttdata.bootcamp.mscustomer.model.CustomerNatural;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerNaturalService {

    Mono<CustomerNatural> createCustomer(Mono<CustomerNatural> customer);
    Mono<Void> deleteCustomer(Integer id);
    Flux<CustomerNatural> listAll();
    Mono<CustomerNatural> listCustomerId(Integer id);
}
