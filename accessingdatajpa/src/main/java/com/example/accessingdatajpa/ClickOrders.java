package com.example.accessingdatajpa;

import javax.persistence.*;

@Entity
public class ClickOrders {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String value;
    private String comment;

    private String date;

    protected ClickOrders() {}

    public ClickOrders(String value, String comment, String date) {
        this.value = value;
        this.comment = comment;
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format(
                "Order[id=%d, value='%s', comment='%s', date='%s']",
                id, value, comment, date);
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }
}
