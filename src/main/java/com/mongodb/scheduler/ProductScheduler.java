package com.mongodb.scheduler;

import com.mongodb.model.Brand;
import com.mongodb.model.Category;
import com.mongodb.model.Product;
import com.mongodb.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Configuration
@AllArgsConstructor
//@EnableScheduling
public class ProductScheduler {

    private final ProductService productService;

    //@Scheduled(initialDelay = 0, fixedDelay = 1000, timeUnit = TimeUnit.MINUTES)
    public void runProductTask() {
        IntStream.range(1, 100).forEach(i -> productService.createProduct(new Product(i + "id", "name" + i, 500 + i, new Category(1, "test"), List.of(new Brand("HNM" + i)))).subscribe());
    }
}
