package com.nttdata.bootcamp.msproduct.aplication;

import com.nttdata.bootcamp.msproduct.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api-product")
public class ProductController {

    private static Logger log = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    ProductService productService;

    @PostMapping("product")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> createProduct(@RequestBody Product product){
        log.debug("requesting the product create route");
        return productService.createProduct(Mono.just(product));
    }

    @GetMapping(value = "getProduct")
    public Flux<Product> listAll(){
        log.debug("requesting the getProduct route");
        return productService.listAll();
    }

    @GetMapping(value = "getProduct/{id}")
    public Mono<Product> listProductId(@PathVariable("id") Integer id){
        log.debug("requesting the getProduct/id route");
        return productService.listProductId(id);
    }

    @DeleteMapping(value = "delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable("id") Integer id){
        log.debug("requesting the delete/id route");
        return productService.deleteProduct(id);
    }
}
