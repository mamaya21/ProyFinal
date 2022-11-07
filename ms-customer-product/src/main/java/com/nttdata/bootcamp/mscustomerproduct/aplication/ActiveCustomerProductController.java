package com.nttdata.bootcamp.mscustomerproduct.aplication;

import com.nttdata.bootcamp.mscustomerproduct.model.ActiveCustomerProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api-account-active")
public class ActiveCustomerProductController {

    @Autowired
    ActiveCustomerProductService activeCustomerProductService;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ActiveCustomerProduct> createActiveCustomProd(@RequestBody ActiveCustomerProduct activeCustomerProduct){
        return activeCustomerProductService.createActiveCustomProd(Mono.just(activeCustomerProduct));
    }

    @GetMapping(value = "get")
    public Flux<ActiveCustomerProduct> listActiveCustomProdAll(){
        return activeCustomerProductService.listActiveCustomProdAll();
    }

    @GetMapping(value = "get/{id}")
    public Mono<ActiveCustomerProduct> listActiveCustomProd_Id(@PathVariable("id") Integer id){
        return activeCustomerProductService.listActiveCustomProd_Id(id);
    }

    @DeleteMapping(value = "delete/{id}")
    public Mono<Void> deleteActiveCustomProd(@PathVariable("id") Integer id){
        return activeCustomerProductService.deleteActiveCustomProd(id);
    }
}
