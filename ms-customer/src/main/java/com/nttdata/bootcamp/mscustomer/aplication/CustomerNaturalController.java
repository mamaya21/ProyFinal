package com.nttdata.bootcamp.mscustomer.aplication;

import com.nttdata.bootcamp.mscustomer.model.CustomerNatural;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("customer-natural")
public class CustomerNaturalController {

    private static Logger log = LoggerFactory.getLogger(CustomerNaturalController.class);

    @Autowired
    CustomerNaturalService customerNaturalService;

    @PostMapping("customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CustomerNatural> createCustomer(@RequestBody CustomerNatural customerNatural){
        log.debug("requesting the customer Natural create route");
        return customerNaturalService.createCustomer(Mono.just(customerNatural));
    }

    @GetMapping(value = "getCustomer", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<CustomerNatural> listAll(){
        log.debug("requesting the getCustomer Natural route");
        return customerNaturalService.listAll();
    }

    @GetMapping(value = "getCustomer/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<CustomerNatural> listCustomerId(@PathVariable("id") Integer id){
        log.debug("requesting the getCustomer/id Natural route");
        return customerNaturalService.listCustomerId(id);
    }

    @DeleteMapping(value = "delete/{id}")
    public Mono<Void> deleteCustomer(@PathVariable("id") Integer id){
        log.debug("requesting the delete/id Natural route");
        return customerNaturalService.deleteCustomer(id);
    }
}
