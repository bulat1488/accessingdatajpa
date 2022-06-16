package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.entity.ClickOrders;

public interface ClickOrdersService {

    ClickOrders registerOrders(String goods, String comment);

    ClickOrders getOrders(long id);

    boolean deleteOrders(long id);

}
