package tn.utss.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import tn.utss.model.Stock;

public interface StockRepository extends MongoRepository<Stock, Long> {

}
