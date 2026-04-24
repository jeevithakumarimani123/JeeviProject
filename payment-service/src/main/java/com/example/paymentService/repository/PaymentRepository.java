package com.example.paymentService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.paymentService.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

	Optional<Payment> findByOrderId(Long orderId);

}
