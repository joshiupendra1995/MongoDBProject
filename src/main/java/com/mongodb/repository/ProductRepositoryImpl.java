package com.mongodb.repository;

import com.mongodb.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public ProductRepositoryImpl(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Override
    public Flux<Product> findAllProduct(Pageable pageable) {
        Query query = new Query().with(pageable);
        return reactiveMongoTemplate.find(query, Product.class);
    }

    @Override
    public Flux<Product> findAllProductSortedByProductName(Sort sort) {
        Query query = new Query().with(sort);
        return reactiveMongoTemplate.find(query, Product.class);
    }
}

