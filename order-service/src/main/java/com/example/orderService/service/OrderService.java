package com.example.orderService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.orderService.client.PaymentClient;
import com.example.orderService.dto.OrderRequest;
import com.example.orderService.entity.Orders;
import com.example.orderService.repository.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderService {

	private final OrderRepository repository;

	private final PaymentClient paymentClient;

	public OrderService(OrderRepository repository, PaymentClient paymentClient) {
		this.repository = repository;
		this.paymentClient = paymentClient;
	}

	@CircuitBreaker(name = "paymentService", fallbackMethod = "fallback")
	public Orders createOrder(OrderRequest request) {

		Orders orders = new Orders();
		orders.setProductName(request.getProductName());
		orders.setQuantity(request.getQuantity());
		orders.setAmount(request.getAmount());
		orders.setStatus("CREATED");

		Orders saved = repository.save(orders);

		String msgReceived = paymentClient.processPayment(saved.getId(), saved.getAmount());
		System.out.println(msgReceived);

		saved.setStatus("COMPLETED");
		return saved;
	}

	public Orders fallback(OrderRequest request, Throwable ex) {
		throw new RuntimeException("Payment Service Unavailable");
	}

	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
}
