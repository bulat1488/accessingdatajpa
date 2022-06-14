package com.example.accessingdatajpa.service.impl;

import com.example.accessingdatajpa.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import com.example.accessingdatajpa.service.CustomerService;


import java.sql.Types;

@Service
@AllArgsConstructor
public class CustomerServiceJdbc implements CustomerService {

    private final JdbcTemplate jdbcTemplate;
    private final TransactionTemplate transactionTemplate;


    @Override
    public Customer registerCustomer(String firstName, String lastName) {
        return transactionTemplate.execute(status -> registerCustomerLocking(firstName, lastName));
    }

    private Customer registerCustomerLocking(String firstName, String lastName) {
        jdbcTemplate.execute("LOCK TABLE accessingdatajpa.customer IN ROW EXCLUSIVE MODE");

        long id = generateId();

        jdbcTemplate.update(
                "INSERT INTO accessingdatajpa.customer (id, firstName, lastName) VALUES (?, ?, ?)", id, firstName
        );

        return new Customer(id, firstName, lastName);
    }

    @Override
    public Customer getCustomer(long id) {
        return jdbcTemplate.queryForObject("select id, firstName, lastName from accessingdatajpa.customer where id = ?",
                new Long[]{id},
                new int[]{Types.BIGINT},
                (rs, rowNum) -> {
                    Customer customer = new Customer();
                    customer.setId(rs.getLong("id"));
                    customer.setFirstName(rs.getString("firstName"));
                    customer.setLastName(rs.getString("lastName"));
                    return customer;
                });

    }

    private long generateId() {
        return jdbcTemplate.queryForObject("select coalesce(max(id), 0) from accessingdatajpa.customer", Long.class) + 1;
    }
}
