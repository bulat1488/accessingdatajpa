package com.example.accessingdatajpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClickOrderRepository extends CrudRepository<ClickOrder, Long> {

    List<Customer> findByValue(String value);

    Customer findById(long id);
}
