package com.mongodb.service;

import com.mongodb.model.Category;
import com.mongodb.model.Product;
import com.mongodb.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Mono<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Mono<Product> createProduct(Product product) {
        return productRepository.save(product);
    }

    public Mono<Product> updateProduct(String id, Product product) {
        return productRepository.findById(id)
                .flatMap(existing -> {
                    existing.setProductName(product.getProductName());
                    existing.setPrice(product.getPrice());
                    return productRepository.save(existing);
                });
    }

    public Mono<Void> deleteProduct(String id) {
        return productRepository.deleteById(id);
    }

    public Flux<Product> createAllProducts(List<Product> products) {
        System.out.println("insert all");
        return productRepository.saveAll(products);
    }

    public Mono<Category> findAllCategoriesOfProductWithName(String name){
        return productRepository.findByProductName(name).map(Product::getCategory);
    }

    public Flux<Product> findAllProductsByPagination(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return productRepository.findAllProduct(pageable);

    }

    public Flux<Product> findAllProductSortedByName(){
        Sort sort = Sort.by(Sort.Direction.ASC, "productName");
        return productRepository.findAllProductSortedByProductName(sort);
    }

    public Flux<Product> findByCategoryCategoryName(String categoryName){
        return productRepository.findByCategoryCategoryName(categoryName);
    }

    public Flux<Product> findByBrandsBrandNameStartsWith(String brandName){
        return productRepository.findByBrandsBrandNameStartsWith(brandName);
    }

    public Flux<Product> getByProductName(String productName) {
        return productRepository.getByProductName(productName);
    }
}
