package com.springboot.customerservice.service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.springframework.stereotype.Service;

/**
 * Created by mvisionmacmini on 4/25/2017 AD.
 */
@Service
public interface MongoService {
    public void initDB();
    public MongoClient getMongoClient();
    public MongoCollection getCollecionByName(String collectionName);
    public void closeConnection();
}
