package com.example.thymeleafshopper.shopping.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String productnumber;

 //   @JsonIgnore
 //   @OneToMany(mappedBy = "kund")
 //   private List<BuyOrder> orders;


    public Product(){}

    public Product(String productnumber, String name){
        this.productnumber = productnumber;
        this.name = name;
    }

    //only used for test
    public Product(String productnumber, String name, Long id){
        this.productnumber = productnumber;
        this.name = name;
        this.id=id;
    }

}
