package com.nttdata.bootcamp.mscustomer.aplication;

import com.nttdata.bootcamp.mscustomer.model.CustomerJuridical;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("customer-juridical")
public class CustomerJuridicalController {
    private static Logger log = LoggerFactory.getLogger(CustomerJuridicalController.class);

    @Autowired
    CustomerJuridicalService customerJuridicalService;

    @PostMapping("customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CustomerJuridical> createCustomer(@RequestBody CustomerJuridical customerJuridical){
        log.debug("requesting the customer Juridical create route");
        return customerJuridicalService.createCustomer(Mono.just(customerJuridical));
    }

    @GetMapping(value = "getCustomer")
    public Flux<CustomerJuridical> listAll(){
        log.debug("requesting the getCustomer Juridical route");
        return customerJuridicalService.listAll();
    }

    @GetMapping(value = "getCustomer/{id}")
    public Mono<CustomerJuridical> listCustomerId(@PathVariable("id") Integer id){
        log.debug("requesting the getCustomer/id Juridical route");
        return customerJuridicalService.listCustomerId(id);
    }

    @DeleteMapping(value = "delete/{id}")
    public Mono<Void> deleteCustomer(@PathVariable("id") Integer id){
        log.debug("requesting the delete/id Juridical route");
        return customerJuridicalService.deleteCustomer(id);
    }
}
