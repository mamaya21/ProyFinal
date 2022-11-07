package com.nttdata.bootcamp.mspersistence.application;

import com.nttdata.bootcamp.mspersistence.infraestructure.CustomerJuricalRepository;
import com.nttdata.bootcamp.mspersistence.model.CustomerJuridical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerJuridicalServiceImpl implements CustomerJuridicalService {

    @Autowired
    CustomerJuricalRepository customerJuricalRepository;

    @Override
    public Mono<CustomerJuridical> createCustomer(Mono<CustomerJuridical> customerMono) {
        return customerMono.flatMap(customerJuricalRepository::insert);
    }

    @Override
    public Flux<CustomerJuridical> listAll() {
        return customerJuricalRepository.findAll();
    }

    @Override
    public Mono<CustomerJuridical> listCustomerId(Integer id) {
        return customerJuricalRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteCustomer(Integer id) {
        return customerJuricalRepository.deleteById(id);
    }

}
