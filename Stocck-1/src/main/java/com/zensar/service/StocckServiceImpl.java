package com.zensar.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.zensar.entity.StockEntity;
import com.zensar.repository.StockRepository;
@Service
public class StocckServiceImpl implements StocckService{
	
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;

	
	
	@Scheduled(fixedRate = 3000)
	public void updateIBMStockPrice() {
		Optional<StockEntity> stockOptional= stockRepository.findByName("IBM");;
		

		if (stockOptional.isPresent()) {
		StockEntity stock = stockOptional.get();
		int newPrice = generateRandomPrice();
		stock.setPrice(newPrice);
		stockRepository.save(stock);
	    }

	}
		
	@Scheduled(fixedRate = 3000)
	public void updateRelianceStockPrice() {
		Optional<StockEntity> stockOptional= stockRepository.findByName("Reliance");;
		

		if (stockOptional.isPresent()) {
		StockEntity stock = stockOptional.get();
		int newPrice = generateRandomPrice();
		stock.setPrice(newPrice);
		stockRepository.save(stock);
	    }

	}
	
	@Scheduled(fixedRate = 3000)
	public void updateInfosysStockPrice() {
		Optional<StockEntity> stockOptional= stockRepository.findByName("Infosys");;
		

		if (stockOptional.isPresent()) {
		StockEntity stock = stockOptional.get();
		int newPrice = generateRandomPrice();
		stock.setPrice(newPrice);
		stockRepository.save(stock);
	    }

	}
	
	@Scheduled(fixedRate = 3000)
	public void updateZensarStockPrice() {
		Optional<StockEntity> stockOptional= stockRepository.findByName("Zensar");;
		

		if (stockOptional.isPresent()) {
		StockEntity stock = stockOptional.get();
		int newPrice = generateRandomPrice();
		stock.setPrice(newPrice);
		stockRepository.save(stock);
	    }

	}
	@Scheduled(fixedRate = 3000)
	public void updateAppleStockPrice() {
		Optional<StockEntity> stockOptional= stockRepository.findByName("Apple");
		

		if (stockOptional.isPresent()) {
		StockEntity stock = stockOptional.get();
		int newPrice = generateRandomPrice();
		stock.setPrice(newPrice);
		stockRepository.save(stock);
	    }

	}
		
		
		private int generateRandomPrice() {
			Random rand = new Random();
			int min = 0;
			int max = 200;
			return rand.nextInt((max - min) + 1) + min;
			
		}
		
		@Scheduled(fixedDelay = 3000)
		public void updatedPrice() {
		simpMessagingTemplate.convertAndSend("/topic/stocks", stockRepository.findAll());
		}
	
	@Override
	public List<StockEntity> getAllStockEntities() {
		
		return stockRepository.findAll();
	}

}
