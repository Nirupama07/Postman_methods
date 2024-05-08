// ProductService.java
package com.product.services;

import java.util.ArrayList;
import com.product.model.Product;

public class ProductService {
    private static ProductService productService;
    private static ArrayList<Product> products = new ArrayList<Product>();

    private ProductService() {} // Private constructor to enforce singleton pattern

    public static ProductService getInstance() {
        if (productService == null) {
            productService = new ProductService();
        }
        return productService;
    }

    public boolean addProduct(Product product) {
        if (product.getProductName() == null) {
            return false;
        } else {
            products.add(product); // Fixed method call
            return true;
        }
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getProductId().equals(id)) { // Changed to .equals() for comparing Long values
                return product;
            }
        }
        return null;
    }
}
