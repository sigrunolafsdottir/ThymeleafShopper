package com.example.thymeleafshopper.shopping.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Kund {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String adress;

 //   @JsonIgnore
 //   @OneToMany(mappedBy = "kund")
 //   private List<BuyOrder> orders;

    public Kund(){}

    public Kund(String name, String adress){
        this.name = name;
        this.adress = adress;
    }

}
