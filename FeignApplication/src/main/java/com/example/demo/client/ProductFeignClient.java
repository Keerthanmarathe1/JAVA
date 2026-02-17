package com.example.demo.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;

@FeignClient(
        name = "product-client",
        url = "http://localhost:9999",
        fallback = ProductFeignFallback.class
)
public interface ProductFeignClient {


    @GetMapping("/getProductS1")
    List<Product> findAllMyModel();

    @GetMapping("/getProductS1/{id}")
    Product findById(@PathVariable("id") int id);

    @PostMapping("/setProdS1")
    void save(@RequestBody Product m);

    @DeleteMapping("/deleteProdS1/{id}")
    void delete(@PathVariable("id") int id);

    @PutMapping("/updateProdS1/{id}")
    void update(@PathVariable("id") int id, @RequestBody Product m);
}
