package com.kitesurfing.ab4challenge.controllers;

import com.kitesurfing.ab4challenge.models.Spot;
import com.kitesurfing.ab4challenge.repositories.SpotRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class SpotController {

    private final SpotRepository repo;

    public SpotController(SpotRepository repo) {
        this.repo = repo;
    }

    @GetMapping(value = "/api/spots")
    public List listAllSpots() {
        return this.repo.findAll();
    }

    @GetMapping(value = "/api/spots/{id}")
    public Optional<Spot> getById(@PathVariable("id") String id) {
        return this.repo.findById(id);
    }

    @GetMapping(value = "/api/search")
    public List<Spot> search(@RequestParam String temperature, @RequestParam String location, @RequestParam String windSpeed, @RequestParam String windDirection ){
//        List<Spot> spots = this.repo.searchQuery(temperature, location, windSpeed, windDirection);
//        return spots;
        return this.repo.findAll();
    }
}
