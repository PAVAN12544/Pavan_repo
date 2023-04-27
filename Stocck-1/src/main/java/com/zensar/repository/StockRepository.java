package com.zensar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Integer>{

	Optional<StockEntity> findByName(String string);

}
