package com.example.accessingdatajpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClickOrder {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String value;
    private String comment;

    protected ClickOrder() {}

    public ClickOrder(String value, String comment) {
        this.value = value;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, value='%s', comment='%s']",
                id, value, comment);
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
