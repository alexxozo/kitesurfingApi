package com.kitesurfing.ab4challenge.controllers;

import com.kitesurfing.ab4challenge.models.Experience;
import com.kitesurfing.ab4challenge.models.Spot;
import com.kitesurfing.ab4challenge.repositories.ExperienceRepository;
import com.kitesurfing.ab4challenge.repositories.SpotRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class ExperienceController {

    private final ExperienceRepository repo;

    public ExperienceController(ExperienceRepository repo) {
        this.repo = repo;
    }

    @GetMapping(value = "/api/experiences")
    public List<Experience> listAllExperiences() {
        return this.repo.findAll();
    }

    @GetMapping(value = "/api/experiences/{id}")
    public Optional<Experience> getById(@PathVariable("id") String id) {
        return this.repo.findById(id);
    }

    @PostMapping(value = "/api/experiences")
    public Experience createExperience(@RequestBody Experience experience) {
        return this.repo.save(experience);
    }
}
