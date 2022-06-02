package com.example.accessingdatajpa.repository;

import java.util.List;

import com.example.accessingdatajpa.dto.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    List<Customer> findByLastName(String lastName);
//
//    Customer findById(long id);
}
