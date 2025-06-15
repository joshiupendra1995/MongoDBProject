package com.mongodb.repository;

import com.mongodb.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;

public interface ProductRepositoryCustom {
    Flux<Product> findAllProduct(Pageable pageable);
    Flux<Product> findAllProductSortedByProductName(Sort sort);
}

