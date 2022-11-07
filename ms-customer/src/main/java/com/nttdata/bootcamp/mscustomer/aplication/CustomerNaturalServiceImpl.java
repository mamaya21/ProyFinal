package com.nttdata.bootcamp.mscustomer.aplication;

import com.nttdata.bootcamp.mscustomer.model.CustomerNatural;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerNaturalServiceImpl implements CustomerNaturalService {

    private static Logger log = LoggerFactory.getLogger(CustomerNaturalServiceImpl.class);

    @Autowired
    ReactiveCircuitBreakerFactory reactiveCircuitBreakerFactory;
    WebClient clientPersistence;

    @Autowired
    public CustomerNaturalServiceImpl(WebClient.Builder builder) {
        this.clientPersistence = builder.baseUrl("http://ms-persistence/").build();
    }

    @Override
    public Mono<CustomerNatural> createCustomer(Mono<CustomerNatural> customerMono) {
        return clientPersistence.post()
                .uri("customernatural/")
                .body(customerMono, CustomerNatural.class)
                .retrieve()
                .bodyToMono(CustomerNatural.class)
                .transform(it -> reactiveCircuitBreakerFactory.create("customer-service").run(it, throwable -> Mono.just(new CustomerNatural())));
    }
    @Override
    public Flux<CustomerNatural> listAll() {
        return clientPersistence.get()
                .uri("customernatural/get")
                .retrieve()
                .bodyToFlux(CustomerNatural.class)
                .transform(it -> reactiveCircuitBreakerFactory.create("customer-service").run(it, throwable -> Flux.just(new CustomerNatural())));
    }
    @Override
    public Mono<CustomerNatural> listCustomerId(Integer id) {
        return clientPersistence.get()
                .uri("customernatural/get/{id}", id)
                .retrieve()
                .bodyToMono(CustomerNatural.class)
                .transform(it -> reactiveCircuitBreakerFactory.create("customer-service").run(it, throwable -> Mono.just(new CustomerNatural())));
    }
    @Override
    public Mono<Void> deleteCustomer(Integer id) {
        return clientPersistence.delete()
                .uri("customernatural/delete/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .transform(it -> reactiveCircuitBreakerFactory.create("customer-service").run(it, throwable -> Mono.empty()));
    }

}
