package com.example.demo.service;

import com.example.demo.entity.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.client.DealerClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository repo;
    private final DealerClient dealerClient;

    public VehicleService(VehicleRepository repo,
                          DealerClient dealerClient) {
        this.repo = repo;
        this.dealerClient = dealerClient;
    }

    public Vehicle addVehicle(Vehicle vehicle) {

        // 🔥 Validate dealer exists
        dealerClient.getDealer(vehicle.getDealerId());

        vehicle.setStatus("AVAILABLE");
        return repo.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return repo.findAll();
    }

    public List<Vehicle> getByDealer(Long dealerId) {
        return repo.findByDealerId(dealerId);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        existing.setName(vehicle.getName());
        existing.setBrand(vehicle.getBrand());
        existing.setPrice(vehicle.getPrice());
        existing.setDealerId(vehicle.getDealerId());
        existing.setStatus(vehicle.getStatus());

        return repo.save(existing);
    }

    public void deleteVehicle(Long id) {
        repo.deleteById(id);
    }
}