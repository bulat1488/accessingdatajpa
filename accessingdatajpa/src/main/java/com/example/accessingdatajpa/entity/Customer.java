package com.example.accessingdatajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    private Long id;
    private String firstName;
    private String lastName;

//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "first_name")
//    private String firstName;
//    @Column(name = "last_name")
//    private String lastName;
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "customer_id")
//    private List<ClickOrders> orders=new ArrayList<>();
//
//    public Customer() {}
//
//    public Customer(Long id, String firstName, String lastName) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    @Override
//    public String toString() {
//        return String.format(
//                "Customer[id=%d, firstName='%s', lastName='%s']",
//                id, firstName, lastName);
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
////    public List<ClickOrders> getСlickOrdersList() {
////        return clickOrders;
////    }
////
////    @PreRemove
////    private void removeFromClickOrders(){
////        for (ClickOrders clickOrders : clickOrders)
////            clickOrders.getCustomers().remove(this);
////    }
}
