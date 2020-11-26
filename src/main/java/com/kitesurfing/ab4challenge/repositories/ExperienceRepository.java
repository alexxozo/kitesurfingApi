package com.kitesurfing.ab4challenge.repositories;

import com.kitesurfing.ab4challenge.models.Experience;
import com.kitesurfing.ab4challenge.models.Spot;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ExperienceRepository extends MongoRepository<Experience, String> {
    @Override
    Optional<Experience> findById(String field);
}
