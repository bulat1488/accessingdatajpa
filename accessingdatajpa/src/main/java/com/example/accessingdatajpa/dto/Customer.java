package com.example.accessingdatajpa.dto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "customer_clickOrders",
            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName =  "id"),
            inverseJoinColumns = @JoinColumn(name = "clickOrders_id", referencedColumnName = "id")
    )
    private List<ClickOrders> clickOrders;

//    protected Customer() {}
//
//    public Customer(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<ClickOrders> getСlickOrdersList() {
        return clickOrders;
    }

    @PreRemove
    private void removeFromClickOrders(){
        for (ClickOrders clickOrders : clickOrders)
            clickOrders.getCustomers().remove(this);
    }
}
