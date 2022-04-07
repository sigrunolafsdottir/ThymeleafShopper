package com.example.thymeleafshopper.shopping.repositories;

import com.example.thymeleafshopper.shopping.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}