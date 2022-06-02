package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.dto.ClickOrders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClickOrderRepository extends CrudRepository<ClickOrders, Long> {

    List<ClickOrders> findByValue(String value);

    ClickOrders findById(long id);
}
