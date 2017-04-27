package com.springboot.customerservice.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by Admin on 26/4/2560.
 */
@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;

    public Object findAll(){
        return this.customerDao.findAll();
    }
}
