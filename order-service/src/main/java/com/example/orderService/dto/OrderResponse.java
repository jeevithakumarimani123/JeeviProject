package com.example.orderService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
	
	  private Long id;

	  private String productName;

	  private Integer quantity;

	  private Double amount;

	  private String status;

}
