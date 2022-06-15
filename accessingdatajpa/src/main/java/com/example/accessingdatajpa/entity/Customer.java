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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
   // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
   // private List<ClickOrders> orders=new ArrayList<>();
}
