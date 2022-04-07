package com.example.thymeleafshopper.shopping.controllers;

import com.example.thymeleafshopper.shopping.models.BuyOrder;
import com.example.thymeleafshopper.shopping.models.Kund;
import com.example.thymeleafshopper.shopping.repositories.BuyOrderRepository;
import com.example.thymeleafshopper.shopping.repositories.KundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class BuyOrderController {

    @Autowired
    private KundRepository kundRepository;
    @Autowired
    private BuyOrderRepository orderRepository;

    @RequestMapping("/add")
    public String addNewOrder(@RequestParam String ordernummer, @RequestParam long kund) {

        BuyOrder o = new BuyOrder();
        o.setOrdernummer(ordernummer);

        Kund k= kundRepository.findById(kund).get();
        if (k != null) {
            o.setKund(k);
        }

        orderRepository.save(o);
        return "Order med nr "+ ordernummer + " is Saved";
    }

    //Kräver cascade=CascadeType.ALL på kund i BuyOrder
    @RequestMapping("/add2")
    public String addNewOrder2(@RequestParam String ordernummer, @RequestParam String name,
                               @RequestParam String adress) {

        BuyOrder o = new BuyOrder();
        o.setOrdernummer(ordernummer);

        Kund k = new Kund();
        k.setName(name);
        k.setAdress(adress);
        o.setKund(k);

        orderRepository.save(o);
        return "Order med nr "+ ordernummer + " is Saved";
    }


    @RequestMapping("/all")
    public Iterable<BuyOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    @RequestMapping("/getById")
    public BuyOrder getOById(@RequestParam Long id) {
        return orderRepository.findById(id).get();
    }


}
