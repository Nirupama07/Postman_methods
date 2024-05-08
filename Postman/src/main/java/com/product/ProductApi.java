// ProductApi.java
package com.product;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.product.model.Product;
import com.product.services.ProductService;

@SuppressWarnings("serial")
public class ProductApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            String productId = req.getParameter("id");

            Product product = ProductService.getInstance().getProductById(Long.parseLong(productId));
            JSONObject obj = new JSONObject();
            if (product != null) {
                obj.put("productName", product.getProductName());
            } else {
                obj.put("error", "Product not found");
            }

            res.getWriter().append(obj.toString());
        } catch (Exception e) {
            res.getWriter().append("invalid");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            BufferedReader reader = req.getReader();
            StringBuilder requestBody = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }

            JSONObject obj = new JSONObject(requestBody.toString());

            Product product = new Product();
            product.setProductName(obj.getString("productName")); // Changed key to "productName"
            product.setDescription(obj.getString("description")); // Changed key to "description"

            ProductService.getInstance().addProduct(product);

            res.getWriter().append("Product added successfully");
        } catch (Exception e) {
            res.getWriter().append("Error occurred while adding product");
        }
    }
}
