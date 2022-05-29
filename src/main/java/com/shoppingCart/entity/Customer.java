package com.shoppingCart.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CustId",
            nullable=false,
            insertable = false
    )
    private Integer custId;

    @Column(
            name="CustName",
            nullable=false,
            columnDefinition = "TEXT"
    )
    private String custName;
    @Column(
            name="MobileNumber",
            unique = true,
            nullable = false,
            length = 10
    )
    private Integer mobNumber;

    @Column(
            name="Country",
    nullable = false
    )
    private String country;

    @BatchSize(size=100)
    @OneToMany(mappedBy  ="customer", fetch=FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<FoodItem> items=new ArrayList<FoodItem>();

}
