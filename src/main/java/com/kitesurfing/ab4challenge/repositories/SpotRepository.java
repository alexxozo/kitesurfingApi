package com.kitesurfing.ab4challenge.repositories;

import com.kitesurfing.ab4challenge.models.Spot;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SpotRepository extends MongoRepository<Spot, String>, SpotRepositoryCustom {
    @Override
    Optional<Spot> findById(String field);

    List<Spot> findByCountry(String country);
    Spot findFirstByName(String name);
    List<Spot> findByWindProbabilityBetween(int from, int to);


}
