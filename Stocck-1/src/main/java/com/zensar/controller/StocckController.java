package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.StockEntity;
import com.zensar.service.StocckService;

@RestController
public class StocckController {

	@Autowired
	StocckService stockService;

	@MessageMapping("/stocks")
	@SendTo("/topic/stocks")
	public List<StockEntity> getAllStocks() {
		List<StockEntity> stocks = stockService.getAllStockEntities();
		return stocks;
	}
}
