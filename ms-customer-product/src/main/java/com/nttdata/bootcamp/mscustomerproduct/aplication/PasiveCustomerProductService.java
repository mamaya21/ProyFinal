package com.nttdata.bootcamp.mscustomerproduct.aplication;

import com.nttdata.bootcamp.mscustomerproduct.model.PasiveCustomerProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PasiveCustomerProductService {
    Mono<PasiveCustomerProduct> createPasiveCustomProd(Mono<PasiveCustomerProduct> pasiveCustomerProductMono);
    Flux<PasiveCustomerProduct> listPasiveCustomProdAll();
    Mono<PasiveCustomerProduct> listPasiveCustomProd_Id(Integer id);
    Mono<Void> deletePasiveCustomProd(Integer id);
}
