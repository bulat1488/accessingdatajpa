package com.example.accessingdatajpa.controller;


import com.example.accessingdatajpa.entity.Customer;
//import com.example.accessingdatajpa.repository.ClickOrderRepository;
import com.example.accessingdatajpa.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/customer/{customerId}")
    public Customer getCustomer(@PathVariable long customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping(path = "/customer")
    public Customer getCustomer(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer.getFirstName(), customer.getLastName());
    }

}
