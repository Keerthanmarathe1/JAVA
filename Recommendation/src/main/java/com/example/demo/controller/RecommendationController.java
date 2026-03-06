package com.example.demo.controller;

import com.example.demo.dto.RecommendationRequest;
import com.example.demo.entity.Bike;
import com.example.demo.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/recommend")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @PostMapping
    public List<Bike> recommend(@RequestBody RecommendationRequest request) {

        return service.recommendFromUser(
                request.getSession().getBudget(),
                request.getSession().getDailyKm(),
                request.getSession().getRideType(),
                request.getSession().getMileage()
        );
    }
}