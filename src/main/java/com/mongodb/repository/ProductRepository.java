package com.mongodb.repository;


import com.mongodb.model.Product;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveMongoRepository<Product, String>, ProductRepositoryCustom {

    Mono<Product> findByProductName(String productName);
    Flux<Product> findByCategoryCategoryName(String categoryName);
    Flux<Product> findByBrandsBrandNameStartsWith(String brandName);
    @Query("{ 'productName': ?0}")
    Flux<Product> getByProductName(String productName);
}

