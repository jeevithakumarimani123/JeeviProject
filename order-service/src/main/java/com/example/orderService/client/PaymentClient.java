package com.example.orderService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="payment-service")
public interface PaymentClient {

   @PostMapping("/payments/doPayment")
   String processPayment(@RequestParam Long orderId,
                       @RequestParam Double amount);
}
