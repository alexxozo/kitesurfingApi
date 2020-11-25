package com.kitesurfing.ab4challenge.repositories;

import com.kitesurfing.ab4challenge.models.Spot;
import com.mongodb.BasicDBObject;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SpotRepositoryImpl implements SpotRepositoryCustom {

    private static final String collection = "spots";

    MongoTemplate mongoTemplate;

    @Autowired
    public SpotRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<String> findDistinct(String field) {
        DistinctIterable<String> iterable = mongoTemplate.getDb().getCollection(collection).distinct(field, String.class);
        MongoCursor<String> cursor = iterable.iterator();
        List<String> list = new ArrayList<>();
        while (cursor.hasNext()) {
            list.add(cursor.next());
        }
        return list;
    }


    @Override
    public List<Spot> searchQuery(String temperature, String location, double windSpeed, String windDirection) {
        
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("temperature", temperature);
        searchQuery.put("location", location);
        searchQuery.put("windSpeed", windSpeed);
        searchQuery.put("windDirection", windDirection);
        FindIterable<Document> iterable = mongoTemplate.getDb().getCollection(collection).find(searchQuery);
        MongoCursor<Document> cursor = iterable.iterator();
        List<Spot> list = new ArrayList<>();
        while (cursor.hasNext()) {
            list.add(new Gson().fromJson(cursor.next().toJson(), Spot.class));
        }
        return list;
    }
}
