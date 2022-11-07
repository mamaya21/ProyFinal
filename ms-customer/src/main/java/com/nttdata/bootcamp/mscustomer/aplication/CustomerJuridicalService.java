package com.nttdata.bootcamp.mscustomer.aplication;

import com.nttdata.bootcamp.mscustomer.model.CustomerJuridical;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerJuridicalService {

    Mono<CustomerJuridical> createCustomer(Mono<CustomerJuridical> customerJuridicalMono);
    Mono<Void> deleteCustomer(Integer id);
    Flux<CustomerJuridical> listAll();
    Mono<CustomerJuridical> listCustomerId(Integer id);
}
