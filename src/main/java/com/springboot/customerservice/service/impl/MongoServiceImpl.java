package com.springboot.customerservice.service.impl;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.springboot.customerservice.service.MongoService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by mvisionmacmini on 4/25/2017 AD.
 */
@Service
public class MongoServiceImpl implements MongoService {

    MongoClient mongoClient = null;

    public MongoServiceImpl(){
        initDB();
    }

    public void initDB(){
        this.mongoClient = new MongoClient("localhost", 27017);
    }

    public MongoClient getMongoClient(){
        return this.mongoClient;
    }

    public MongoCollection getCollecionByName(String collectionName){
        return this.mongoClient.getDatabase("local").getCollection(collectionName);
    }
    public void closeConnection(){
        this.mongoClient.close();
    }
}
