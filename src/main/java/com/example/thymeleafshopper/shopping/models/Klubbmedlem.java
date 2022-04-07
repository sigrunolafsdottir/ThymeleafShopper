package com.example.thymeleafshopper.shopping.models;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Klubbmedlem {

        @Id
        @GeneratedValue
        private Long id;
        private String medlemsnummer;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn
        private Kund kund;

        public Klubbmedlem(){}

        public Klubbmedlem(String medlemsnummer, Kund kund){
                this.medlemsnummer = medlemsnummer;
                this.kund = kund;
        }

}
