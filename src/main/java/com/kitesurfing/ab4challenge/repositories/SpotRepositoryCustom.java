package com.kitesurfing.ab4challenge.repositories;

import com.kitesurfing.ab4challenge.models.Spot;
import com.kitesurfing.ab4challenge.models.Temperature;
import org.bson.Document;

import java.util.List;

public interface SpotRepositoryCustom {
    List<String> findDistinct(String field);
}
