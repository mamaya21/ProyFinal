package com.nttdata.bootcamp.mscustomer.aplication;

import com.nttdata.bootcamp.mscustomer.model.CustomerJuridical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerJuridicalServiceImpl implements CustomerJuridicalService{

    @Autowired
    ReactiveCircuitBreakerFactory reactiveCircuitBreakerFactory;
    WebClient clientPersistence;

    @Autowired
    public CustomerJuridicalServiceImpl(WebClient.Builder builder) {
        this.clientPersistence = builder.baseUrl("http://ms-persistence/").build();
    }

    @Override
    public Mono<CustomerJuridical> createCustomer(Mono<CustomerJuridical> customerMono) {
        return clientPersistence.post()
                .uri("customerjuridical/")
                .body(customerMono, CustomerJuridical.class)
                .retrieve()
                .bodyToMono(CustomerJuridical.class)
                .transform(it -> reactiveCircuitBreakerFactory.create("customer-service").run(it, throwable -> Mono.just(new CustomerJuridical())));
    }
    @Override
    public Flux<CustomerJuridical> listAll() {
        return clientPersistence.get()
                .uri("customerjuridical/get")
                .retrieve()
                .bodyToFlux(CustomerJuridical.class)
                .transform(it -> reactiveCircuitBreakerFactory.create("customer-service").run(it, throwable -> Flux.just(new CustomerJuridical())));
    }
    @Override
    public Mono<CustomerJuridical> listCustomerId(Integer id) {
        return clientPersistence.get()
                .uri("customerjuridical/get/{id}", id)
                .retrieve()
                .bodyToMono(CustomerJuridical.class)
                .transform(it -> reactiveCircuitBreakerFactory.create("customer-service").run(it, throwable -> Mono.just(new CustomerJuridical())));
    }
    @Override
    public Mono<Void> deleteCustomer(Integer id) {
        return clientPersistence.delete()
                .uri("customerjuridical/delete/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .transform(it -> reactiveCircuitBreakerFactory.create("customer-service").run(it, throwable -> Mono.empty()));
    }

}
