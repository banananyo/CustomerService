package com.springboot.customerservice.domain;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Admin on 26/4/2560.
 */
@Transactional
public interface CustomerDao extends CrudRepository<Customer, Long> {
}
