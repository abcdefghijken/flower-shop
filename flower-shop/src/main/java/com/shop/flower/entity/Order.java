package com.shop.flower.entity;

import jakarta.persistence.*;

import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "total_price")
    @Min(value = 0)
    private int totalPrice;

    @Column(name = "date_of_purchase")
    private Date dateOfPurchase;

    private Customer customer;

    @ManyToMany
    @JoinColumn(name = "order_id")
    private List<Product> products;
}
