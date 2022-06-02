package com.example.accessingdatajpa.dto;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class ClickOrders {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String value;
    private String comment;

    private Timestamp date;

    protected ClickOrders() {}

    public ClickOrders(String value, String comment) {
        this.value = value;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return String.format(
                "Order[id=%d, value='%s', comment='%s']",
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

}
