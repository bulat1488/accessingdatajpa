package com.example.accessingdatajpa.dto;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "clickOrders")
public class ClickOrders {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "value")
    private String value;
    @Column(name = "comment")
    private String comment;
    @Column(name = "date")
    private String date;

    @ManyToMany(mappedBy = "clickOrders")
    private List<Customer> customer;

//    protected ClickOrders() {}
//
//    public ClickOrders(String value, String comment, String date) {
//        this.value = value;
//        this.comment = comment;
//        this.date = date;
//    }

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
    public List<Customer> getCustomers() {
        return customer;
    }

    @PreRemove
    private void removeFromClickOrders(){
        for (Customer customer : customer)
            customer.getСlickOrdersList().remove(this);
    }
}
