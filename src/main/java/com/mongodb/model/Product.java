package com.mongodb.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "products")
public class Product {
    @Id
    private String productId;
    private String productName;
    private double price;
    private Category category;
    private List<Brand> brands;

    @PersistenceCreator
    public Product(String productId, String productName, double price, Category category, List<Brand> brands) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.brands = brands;
    }

    @JsonCreator
    public Product(String productName, Category category, @JsonInclude(JsonInclude.Include.NON_NULL)List<Brand> brands, double price) {
        this.productName = productName;
        this.category = category;
        this.brands = brands;
        this.price = price;
    }
}
