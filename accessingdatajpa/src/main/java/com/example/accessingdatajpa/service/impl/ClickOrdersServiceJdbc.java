package com.example.accessingdatajpa.service.impl;

import com.example.accessingdatajpa.entity.ClickOrders;
import com.example.accessingdatajpa.entity.Customer;
import com.example.accessingdatajpa.service.ClickOrdersService;
import com.example.accessingdatajpa.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.Types;

@Service
@AllArgsConstructor
public class ClickOrdersServiceJdbc implements ClickOrdersService {

    private final JdbcTemplate jdbcTemplate;
    private final TransactionTemplate transactionTemplate;


    @Override
    public ClickOrders registerOrders(String goods, String comment) {
        return transactionTemplate.execute(status -> registerClickOrdersLocking(goods, comment));
    }

    private ClickOrders registerClickOrdersLocking(String goods, String comment) {
        jdbcTemplate.execute("LOCK TABLE accessingdatajpa.clickorders IN ROW EXCLUSIVE MODE");

        long id = generateId();

        jdbcTemplate.update(
                "INSERT INTO accessingdatajpa.clickorders (id, goods, comment) VALUES (?, ?, ?)", id, goods, comment
        );

        return new ClickOrders(id, goods, comment);
    }

    @Override
    public ClickOrders getOrders(long id) {
        return jdbcTemplate.queryForObject("select id, goods, comment from accessingdatajpa.clickorders where id = ?",
                new Long[]{id},
                new int[]{Types.BIGINT},
                (rs, rowNum) -> {
                    ClickOrders clickOrders = new ClickOrders();
                    clickOrders.setId(rs.getLong("id"));
                    clickOrders.setGoods(rs.getString("goods"));
                    clickOrders.setComment(rs.getString("comment"));
                    return clickOrders;
                });

    }

    private long generateId() {
        return jdbcTemplate.queryForObject("select coalesce(max(id), 0) from accessingdatajpa.clickorders", Long.class) + 1;
    }
}
