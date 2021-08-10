package tn.utss.service;

import java.util.List;

import tn.utss.model.Product;

public interface ProductService {

	// ===== CRUD =====//

	List<Product> retrieveAllProducts();

	Product retrieveProduct(long idProduct);

	Product addProduct(Product p);

	Product updateProduct(Product p);

	void deleteProduct(long idProduct);

	// ===== CRUD =====//
}
