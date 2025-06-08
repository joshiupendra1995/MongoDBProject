package com.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "products")
public class Product {
    @Id
    private String productId;
    private String productName;
    private double price;
}
