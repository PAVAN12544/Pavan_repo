package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.StockEntity;
import com.zensar.service.StocckService;

@RestController
public class StocckController {

	@Autowired
	StocckService stockService;

	@GetMapping("/stocks")
	@SendTo("/topic/stocks")
	public List<StockEntity> getAllStocks() {
		List<StockEntity> stocks = stockService.getAllStockEntities();
		return stocks;
	}
}
