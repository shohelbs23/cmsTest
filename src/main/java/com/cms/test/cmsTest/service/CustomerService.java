package com.cms.test.cmsTest.service;

import com.cms.test.cmsTest.dao.CustomerDAO;
import com.cms.test.cmsTest.exception.CustomerNotFoundException;
import com.cms.test.cmsTest.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer){
        return customerDAO.save(customer);
    }

    public List<Customer> getCustomerList(){
        return customerDAO.findAll();
    }

    public Customer getCustomer(int customerId){
        Optional<Customer> customerOptional=customerDAO.findById(customerId);
        if (!customerOptional.isPresent()){
            throw new CustomerNotFoundException("No Record Found");
        }
        return customerDAO.findById(customerId).get();
    }

    public Customer updateCustomer(int customerId,Customer customer){
        customer.setCustomerId(customerId);
        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerId){
        customerDAO.deleteById(customerId);
    }

}
