package com.springboot.customerservice.service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;

/**
 * Created by mvisionmacmini on 4/25/2017 AD.
 */
public interface MongoService {
    public void initDB();
    public MongoClient getMongoClient();
    public MongoCollection getCollecionByName(String collectionName);
}
