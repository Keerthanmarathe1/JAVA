package com.example.demo.client;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Product;

@Component
public class ProductFeignFallback implements ProductFeignClient {

    @Override
    public List<Product> findAllMyModel() {

        System.out.println("🔥 Circuit Breaker Triggered - Service Down");

        Product p = new Product();
        p.setPid(0);
        p.setPname("Service Down");
        p.setSubscription("N/A");
        p.setPrice(0);

        return List.of(p);
    }

    @Override
    public Product findById(int id) {

        Product p = new Product();
        p.setPid(id);
        p.setPname("Service Down");
        p.setSubscription("N/A");
        p.setPrice(0);

        return p;
    }

    @Override
    public void save(Product m) {
        System.out.println("Create failed - Service Down");
    }

    @Override
    public void delete(int id) {
        System.out.println("Delete failed - Service Down");
    }

    @Override
    public void update(int id, Product m) {
        System.out.println("Update failed - Service Down");
    }
}
