package com.kitesurfing.ab4challenge.controllers;

import com.kitesurfing.ab4challenge.models.Details;
import com.kitesurfing.ab4challenge.models.Spot;
import com.kitesurfing.ab4challenge.repositories.SpotRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
        List<Spot> spots = this.repo.findAll();
        return spots;
    }

    @GetMapping(value = "/api/spots/bycountry")
    public List<Spot> listAllSpotsInCountry(@RequestBody Map<String, String> req) {
        String specifiedCountry = req.get("country");
        List<Spot> spots = this.repo.findByCountry(specifiedCountry);
        return spots;
    }

    @GetMapping(value = "/api/spots/bywind")
    public List<Spot> listAllSpotsInInterval(@RequestBody Map<String, String> req) {
        int from = Integer.parseInt(req.get("from"));
        int to = Integer.parseInt(req.get("to"));
        List<Spot> spots = this.repo.findByWindProbabilityBetween(from, to);
        return spots;
    }

//    @GetMapping(value = "/api/spots/{id}")
//    public Details getById(@PathVariable("id") String id) {
//        Optional<Spot> spot = this.repo.findById(id);
//        Details details = new Details();
//
//        if (spot.isPresent()) {
//            Spot actualSpot = spot.get();
//            details = new Details(actualSpot.getLongitude(), actualSpot.getLatitude(), actualSpot.getWhenToGo());
//        }
//        return details;
//    }

    @GetMapping(value = "/api/spots/countries")
    public List<String> getCountries() {
        List<String> countries = repo.findDistinct("country");
        return countries;
    }

    @PostMapping(value = "/api/favorites/spots")
    public String addFavorite(@RequestBody Spot body) {
        return body.toString();
    }
}
