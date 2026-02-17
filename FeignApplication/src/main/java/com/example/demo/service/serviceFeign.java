package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.ProductFeignClient;
import com.example.demo.model.Product;

@Service
public class serviceFeign {

    @Autowired
    private ProductFeignClient feignClient;

    public List<Product> findAllMyModel() {
        return feignClient.findAllMyModel();
    }

    public Product findById(int id) {
        return feignClient.findById(id);
    }

    public void save(Product m) {
        feignClient.save(m);
    }

    public void delete(int id) {
        feignClient.delete(id);
    }

    public void update(int id, Product m) {
        feignClient.update(id, m);
    }
}
