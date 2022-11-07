package com.nttdata.bootcamp.mspersistence.application;

import com.nttdata.bootcamp.mspersistence.model.CustomerJuridical;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerJuridicalService {
    Mono<CustomerJuridical> createCustomer(Mono<CustomerJuridical> product);
    Mono<Void> deleteCustomer(Integer id);
    Flux<CustomerJuridical> listAll();
    Mono<CustomerJuridical> listCustomerId(Integer id);
}
