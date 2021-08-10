package tn.utss.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.utss.model.Product;
import tn.utss.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

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
	public Product addProduct(Product p) {
		p.setIdProduct(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
		return productRepository.save(p);
	}

	@Override
	public Product updateProduct(Product c) {
		return productRepository.save(c);
	}

	@Override
	public void deleteProduct(long idProduct) {
		productRepository.deleteById(idProduct);

	}

}
