package com.nttdata.bootcamp.mspersistence.application;

import com.nttdata.bootcamp.mspersistence.model.CustomerNatural;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerNaturalService {

    Mono<CustomerNatural> createCustomer(Mono<CustomerNatural> customerNaturalMono);
    Mono<Void> deleteCustomer(Integer id);
    Flux<CustomerNatural> listAll();
    Mono<CustomerNatural> listCustomerId(Integer id);
}
