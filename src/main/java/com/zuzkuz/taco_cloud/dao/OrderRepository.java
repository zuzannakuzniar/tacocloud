package com.zuzkuz.taco_cloud.dao;

import com.zuzkuz.taco_cloud.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Order save(Order order);
}
