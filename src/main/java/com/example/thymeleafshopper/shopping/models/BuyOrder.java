package com.example.thymeleafshopper.shopping.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class BuyOrder {

    @Id
    @GeneratedValue
    private Long id;
    private String ordernummer;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn
    private Kund kund;

    @ManyToMany(cascade = CascadeType.ALL)
  //  @JoinTable(name="orderDetail", joinColumns={@JoinColumn(referencedColumnName="id")},
 //           inverseJoinColumns={@JoinColumn(referencedColumnName="id")})
    @JoinTable
    private List<Product> products;

    public BuyOrder(){}

    public BuyOrder(String ordernummer, Kund kund){
        this.ordernummer = ordernummer;
        this.kund = kund;
    }

    public BuyOrder(String ordernummer, Kund kund, List<Product> orderDetails){
        this.ordernummer = ordernummer;
        this.kund = kund;
        this.products = orderDetails;
    }

}
