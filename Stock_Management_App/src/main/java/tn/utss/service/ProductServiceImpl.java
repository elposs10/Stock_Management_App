package tn.utss.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.utss.model.Product;
import tn.utss.model.Stock;
import tn.utss.repository.ProductRepository;
import tn.utss.repository.StockRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	StockRepository stockRepository;

	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	private static final Logger L = LogManager.getLogger(ProductServiceImpl.class);

	@Override
	public List<Product> retrieveAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product retrieveProduct(long idProduct) {
		Product Product = productRepository.findById(idProduct).get();
		L.info("Product returned +++ :" + Product);
		return Product;
	}

	@Override
	public Product addProduct(Product p,long idStock) {
		p.setIdProduct(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
		Stock Stk=stockRepository.findById(idStock).get();
		Stk.getStockProducts().add(p);
		stockRepository.save(Stk);
		return productRepository.save(p);
	}

	@Override
	public Product updateProduct(Product p,long idStock) {
		
		//long id = -1;
		 List<Product> StockProds =stockRepository.findById(idStock).get().getStockProducts();
		 for (Product p1 : StockProds) {
			    if (p.getBarcode()==(p1.getBarcode())){
			         long id= p.getIdProduct();
			    
		 Product existingProduct=productRepository.findById(id).get();
//		Product existingProduct=stockRepository.findById(idStock).get().getStockProducts().get(Math.toIntExact(p.getIdProduct()));
		existingProduct.setQuantityProduct(p.getQuantityProduct());
		
		
		productRepository.save(existingProduct);
			    }
			}
		 return(p);
	}

	@Override
	public void deleteProduct(long idProduct) {
		productRepository.deleteById(idProduct);

	}

}
