package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.entity.Customer;

public interface CustomerService {

    Customer registerCustomer(String firstName, String lastName);

    Customer getCustomer(long id);

}
