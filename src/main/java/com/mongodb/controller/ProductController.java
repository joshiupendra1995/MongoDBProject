package com.mongodb.controller;

import com.mongodb.model.Category;
import com.mongodb.model.Product;
import com.mongodb.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Flux<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProduct(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Mono<Product> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PostMapping("/all")
    public Flux<Product> createAllProducts(@RequestBody List<Product> products) {
        return productService.createAllProducts(products);
    }

    @PutMapping("/{id}")
    public Mono<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/product/{name}")
    public Mono<Category> findAllCategoriesForProductName(@PathVariable String name) {
        return productService.findAllCategoriesOfProductWithName(name);
    }

    @GetMapping("/pagination")
    public Flux<Product> findAllProductsByPagination(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return productService.findAllProductsByPagination(pageNumber, pageSize);
    }

    @GetMapping("/sorted")
    public Flux<Product> findAllProductSortedByName(){
        return productService.findAllProductSortedByName();
    }

    @GetMapping("/category")
    public Flux<Product> findByCategoryCategoryName(@RequestParam String categoryName){
        return productService.findByCategoryCategoryName(categoryName);
    }

    @GetMapping("/brands")
    public Flux<Product> findByBrandsBrandNameStartsWith(@RequestParam String brandName){
        return productService.findByBrandsBrandNameStartsWith(brandName);
    }

    @GetMapping("/product/native/{productName}")
    public Flux<Product> getByProductName(@PathVariable String productName){
        return productService.getByProductName(productName);
    }
}

