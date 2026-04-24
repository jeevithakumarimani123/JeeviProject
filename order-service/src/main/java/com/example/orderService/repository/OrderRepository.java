package com.example.orderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orderService.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
