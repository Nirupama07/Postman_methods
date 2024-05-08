// Product.java
package com.product.model;

import java.util.Random;

public class Product {
    private String productName;
    private String description;
    private Long productId; // Changed type to Long

    public Product() {
        Random rand = new Random();
        this.productId = rand.nextLong(); // Generate a random Long value
    }

    // Getters and setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getProductId() {
        return productId;
    }
}
