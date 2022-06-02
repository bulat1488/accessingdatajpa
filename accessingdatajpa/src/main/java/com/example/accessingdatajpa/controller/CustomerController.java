package com.example.accessingdatajpa.controller;


import com.example.accessingdatajpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequstMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
}
