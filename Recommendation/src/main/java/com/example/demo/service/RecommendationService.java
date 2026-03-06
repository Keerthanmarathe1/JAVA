package com.example.demo.service;

import com.example.demo.entity.Bike;
import com.example.demo.repository.BikeRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RecommendationService {

    private final BikeRepository repo;

    public RecommendationService(BikeRepository repo) {
        this.repo = repo;
    }

    public List<Bike> recommendFromUser(double budget, double dailyKm, String rideType, int mileage) {

        List<Bike> bikes = repo.findAll();

        return bikes.stream()

                .filter(b -> b.getRideType().equalsIgnoreCase(rideType))

                .sorted(Comparator.comparingDouble(
                        (Bike b) -> scoreBike(b, budget, dailyKm, mileage)
                ).reversed())

                .limit(3)

              

                .toList();
    }


    private double scoreBike(Bike bike, double budget, double dailyKm, int mileage) {

        double score = 0;

        // budget match
        double priceDiff = Math.abs(budget - bike.getPrice());
        score += (200000 - priceDiff) / 1000;

        // mileage match
        if (bike.getMileage() >= mileage) {
            score += 20;
        }

        // daily km suitability
        if (bike.getSuitableDailyKm() >= dailyKm) {
            score += 15;
        }

        return score;
    }
}