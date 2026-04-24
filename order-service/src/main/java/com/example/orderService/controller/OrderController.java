package com.example.orderService.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderService.dto.OrderRequest;
import com.example.orderService.entity.Orders;
import com.example.orderService.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	private final OrderService service;
	
	public OrderController(OrderService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Orders> getAllOrders() {
		return service.getAllOrders();
	}

    @PostMapping("/create")
    public Orders createOrder(@Valid @RequestBody OrderRequest request) {
        return service.createOrder(request);
    }

}
