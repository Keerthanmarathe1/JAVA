package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;
import com.example.demo.service.serviceFeign;

@RestController
@RequestMapping("/feign")
public class ProductFeignController {

    @Autowired
    private serviceFeign service;

    // Get All Products
    @GetMapping("/getProducts")
    public List<Product> getAllProducts() {
        return service.findAllMyModel();
    }

    // Get Product By ID
    @GetMapping("/getProduct/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.findById(id);
    }

    // Create Product
    @PostMapping("/create")
    public String createProduct(@RequestBody Product product) {
        service.save(product);
        return "Product Created Successfully";
    }

    // Delete Product
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        service.delete(id);
        return "Product Deleted Successfully";
    }

    // Update Product
    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product product) {
        service.update(id, product);
        return "Product Updated Successfully";
    }
}
