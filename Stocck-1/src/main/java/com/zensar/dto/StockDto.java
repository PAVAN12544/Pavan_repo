package com.zensar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {
	
	public int id;
	public String name;
	public int price;
	
	
	public StockDto(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}}
	
	