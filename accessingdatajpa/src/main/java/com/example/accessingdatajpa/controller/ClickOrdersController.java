package com.example.accessingdatajpa.controller;


import com.example.accessingdatajpa.entity.ClickOrders;
import com.example.accessingdatajpa.entity.Customer;
import com.example.accessingdatajpa.service.ClickOrdersService;
import com.example.accessingdatajpa.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class ClickOrdersController {

    @Autowired
    private ClickOrdersService clickOrdersService;

    @GetMapping(path = "/clickorders/{clickordersId}")
    public ClickOrders getOrders(@PathVariable long clickordersId) {
        return clickOrdersService.getOrders(clickordersId);
    }

    @PostMapping(path = "/clickorders")
    public ClickOrders getCustomer(@RequestBody ClickOrders clickOrders) {
        return clickOrdersService.registerOrders(clickOrders.getGoods(), clickOrders.getComment());
    }

}
