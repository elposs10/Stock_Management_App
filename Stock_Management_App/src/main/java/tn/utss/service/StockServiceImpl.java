package tn.utss.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.utss.model.Product;
import tn.utss.model.Stock;
import tn.utss.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	private static final Logger L = LogManager.getLogger(StockServiceImpl.class);

	@Override
	public List<Stock> retrieveAllStocks() {
		return stockRepository.findAll();
	}

	@Override
	public Stock retrieveStock(long idStock) {
		Stock Stock = stockRepository.findById(idStock).get();
		L.info("Stock returned +++ :" + Stock);
		return Stock;
	}

	@Override
	public Stock addStock(Stock s) {
		s.setIdStock(sequenceGeneratorService.generateSequence(Stock.SEQUENCE_NAME));
		List<Product> StkProds=new ArrayList<Product>();
		s.setStockProducts(StkProds);
		return stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock c) {
		return stockRepository.save(c);
	}

	@Override
	public void deleteStock(long idStock) {
		stockRepository.deleteById(idStock);

	}
}
