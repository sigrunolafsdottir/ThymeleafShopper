package com.example.thymeleafshopper.shopping.repositories;

import com.example.thymeleafshopper.shopping.models.BuyOrder;
import org.springframework.data.repository.CrudRepository;

public interface BuyOrderRepository extends CrudRepository<BuyOrder, Long> {

}