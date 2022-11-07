package com.nttdata.bootcamp.mspersistence.application;

import com.nttdata.bootcamp.mspersistence.model.PasiveCustomerProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PasiveCustomerProductService {
    Mono<PasiveCustomerProduct> createPasiveCustomProd(Mono<PasiveCustomerProduct> pasiveCustomerProductMono);
    Flux<PasiveCustomerProduct> listPasiveCustomProdAll();
    Mono<PasiveCustomerProduct> listPasiveCustomProd_Id(Integer id);
    Mono<Void> deletePasiveCustomProd(Integer id);
}

