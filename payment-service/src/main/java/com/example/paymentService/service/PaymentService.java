package com.example.paymentService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.paymentService.entity.Payment;
import com.example.paymentService.repository.PaymentRepository;


@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository repository;
	
	
	public Payment processPayment(Long orderId, Double amount) {

	    Optional<Payment> existing = repository.findByOrderId(orderId);
	    if(existing.isPresent()){
	        throw new RuntimeException("Payment already processed");
	    }

	    Payment payment = new Payment();
	    payment.setOrderId(orderId);
	    payment.setAmount(amount);
	    payment.setStatus("SUCCESS");

	    return repository.save(payment);
	}

}
