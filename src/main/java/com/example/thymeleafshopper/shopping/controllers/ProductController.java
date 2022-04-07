package com.example.thymeleafshopper.shopping.controllers;


import com.example.thymeleafshopper.shopping.models.Product;
import com.example.thymeleafshopper.shopping.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping( "/add")
    public String addNew(@RequestParam String name, @RequestParam String productNumber) {

        Product n = new Product();
        n.setName(name);
        n.setProductnumber(productNumber);
        productRepository.save(n);
        return name + " is Saved";
    }

    @RequestMapping("/all")
    public Iterable<Product> getAll() {
        Iterable<Product> k = productRepository.findAll();
        return k;
    }

    @RequestMapping("/getById")
    public Product getById(@RequestParam Long id) {

        return productRepository.findById(id).get();
    }


}
