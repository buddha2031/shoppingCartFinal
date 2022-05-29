package com.shoppingCart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Table(name="Item")
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FoodId",
            nullable = false,
            updatable = false)

    private Integer foodId;

    @Column(name = "ItemName",
            nullable = false)
    private String itemName;

    @Column(name = "Quantity",
            nullable = false
    )
    private Integer quantity;

    @ManyToOne(fetch=FetchType.LAZY)
    private Customer customer;

    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer customer){
        this.customer=customer;
    }

}


