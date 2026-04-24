package com.example.orderService.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderRequest {

	  @NotBlank
	  private String productName;

	  @Min(1)
	  private Integer quantity;

	  @Positive
	  private Double amount;
	}