package com.nttdata.bootcamp.mspersistence.application;

import com.nttdata.bootcamp.mspersistence.infraestructure.CustomerNaturalRepository;
import com.nttdata.bootcamp.mspersistence.model.CustomerNatural;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerNaturalServiceImpl implements CustomerNaturalService {

    @Autowired
    CustomerNaturalRepository customerNaturalRepository;

    @Override
    public Mono<CustomerNatural> createCustomer(Mono<CustomerNatural> customerMono) {
        return customerMono.flatMap(customerNaturalRepository::insert);
    }

    @Override
    public Flux<CustomerNatural> listAll() {
        return customerNaturalRepository.findAll();
    }

    @Override
    public Mono<CustomerNatural> listCustomerId(Integer id) {
        return customerNaturalRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteCustomer(Integer id) {
        return customerNaturalRepository.deleteById(id);
    }

}
