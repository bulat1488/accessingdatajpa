package com.example.accessingdatajpa.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClickOrders {

    @Id
    private Long id;
    private String goods;
    private String comment;
}
