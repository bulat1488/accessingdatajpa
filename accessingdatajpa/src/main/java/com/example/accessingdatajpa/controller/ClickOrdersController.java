package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.entity.ClickOrders;
import com.example.accessingdatajpa.service.ClickOrdersService;
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
    public ClickOrders regOrders(@RequestBody ClickOrders clickOrders) {
        return clickOrdersService.registerOrders(clickOrders.getGoods(), clickOrders.getComment());
    }

    @DeleteMapping(path = "/clickorders/delete/{clickordersId}")
    public boolean deleteOrders(@PathVariable long clickordersId) {
        return clickOrdersService.deleteOrders(clickordersId);
    }
}
