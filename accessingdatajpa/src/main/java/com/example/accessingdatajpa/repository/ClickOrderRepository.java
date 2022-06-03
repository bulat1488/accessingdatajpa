package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.dto.ClickOrders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClickOrderRepository extends JpaRepository<ClickOrders, Long> {

}
