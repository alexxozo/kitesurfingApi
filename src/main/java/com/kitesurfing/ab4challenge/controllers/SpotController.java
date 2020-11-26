package com.kitesurfing.ab4challenge.controllers;

import com.kitesurfing.ab4challenge.models.Spot;
import com.kitesurfing.ab4challenge.repositories.SpotRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        System.out.println(spots);
        return spots;
    }

    @GetMapping(value = "/api/spots/{id}")
    public Optional<Spot> getById(@PathVariable("id") String id) {
        return this.repo.findById(id);
    }

    @GetMapping(value = "/api/similar-spots/{id}")
    public Set similarSpots(@PathVariable("id") String id) {
        List<Spot> l = this.repo.findAll();
        Set<Spot> output = new HashSet<>();
        Optional<Spot> spot = getById(id);
        if (spot.isEmpty()) return null;
        Spot actualSpot = spot.get();

        for(Spot s: l) {
            if (!s.equals(actualSpot) && output.size() < 3) {
                if (s.getLocation().equals(actualSpot.getLocation())) {
                    output.add(s);
                } else if (s.getTemperature().equals(actualSpot.getTemperature())) {
                    output.add(s);
                } else if (Math.abs(s.getWindSpeed() - actualSpot.getWindSpeed()) < 1e-6) {
                    output.add(s);
                } else if (s.getWindDirection().equals(actualSpot.getWindDirection())) {
                    output.add(s);
                }
            }
        }
        if (output.size() < 3) {
            while(output.size() < 3) {
                int random = new Random().nextInt(l.size());
                if (!l.get(random).equals(actualSpot)) {
                    output.add(l.get(random));
                }
            }
        }
        return output;

    }

    @GetMapping(value = "/api/search")
    public List searchQuery(@RequestParam(value = "temperature", required = false) String temperature,
                             @RequestParam(value = "location", required = true) String location,
                             @RequestParam(value = "windSpeed", required = true) double windSpeed,
                             @RequestParam(value = "windDirection", required = true) String windDirection ){
        List<Spot> l = this.repo.findAll();
        List<Spot> output = new ArrayList<>();
        for(Spot s: l){
            if(s.getLocation().equals(location)){
                output.add(s);
            } else if(Math.abs(Integer.valueOf(s.getTemperature()) - (Integer.valueOf(temperature))) < 5){
                output.add(s);
            } else if(Math.abs(s.getWindSpeed() - windSpeed) < 10){ ;
                output.add(s);
            } else if(s.getWindDirection().equals(windDirection)){
                output.add(s);
            }
        }
        SearchResult out = new SearchResult(output);
        return out.getOutput();

    }

    public class SearchResult {
        private List output;

        public SearchResult(List output) {
            this.output = output;
        }

        public List getOutput() {
            return output;
        }
    }
//     @GetMapping
//     public Set<Map.Entry<String, String>> search(@RequestParam Map<String, String> allParams) {
//        System.out.println(allParams.entrySet());
//        return allParams.entrySet();
//    }
//
//    @GetMapping(value = "/api/spots/bywind")
//    public List<Spot> listAllSpotsInInterval(@RequestBody Map<String, String> req) {
//        int from = Integer.parseInt(req.get("from"));
//        int to = Integer.parseInt(req.get("to"));
//        List<Spot> spots = this.repo.findByWindProbabilityBetween(from, to);
//        return spots;
//    }
//
////    @GetMapping(value = "/api/spots/{id}")
////    public Details getById(@PathVariable("id") String id) {
////        Optional<Spot> spot = this.repo.findById(id);
////        Details details = new Details();
////
////        if (spot.isPresent()) {
////            Spot actualSpot = spot.get();
////            details = new Details(actualSpot.getLongitude(), actualSpot.getLatitude(), actualSpot.getWhenToGo());
////        }
////        return details;
////    }
//
//    @GetMapping(value = "/api/spots/countries")
//    public List<String> getCountries() {
//        List<String> countries = repo.findDistinct("country");
//        return countries;
//    }
//
//    @PostMapping(value = "/api/favorites/spots")
//    public String addFavorite(@RequestBody Spot body) {
//        return body.toString();
//    }
}
