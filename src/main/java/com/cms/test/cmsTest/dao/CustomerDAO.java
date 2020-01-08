package com.cms.test.cmsTest.dao;

import com.cms.test.cmsTest.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerDAO extends CrudRepository<Customer,Integer> {

    @Override
    List<Customer> findAll();
}
