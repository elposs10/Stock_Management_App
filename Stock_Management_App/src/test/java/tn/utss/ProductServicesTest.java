package tn.utss;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.utss.model.Product;
import tn.utss.repository.ProductRepository;
import tn.utss.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServicesTest {

	@Autowired
	ProductService productService;

	@Autowired
	ProductRepository productRepository;

	@Test
	public void testAddProduct() throws ParseException {
		Product p1 = new Product(1, "Fromage", "Frais", 15, 25.00f, 10.25f, 10.00f, 100);
		Product p2 = new Product(2, "Lait", "Complet", 25, 0.9f, 1.00f, 1.25f, 250);
		Product p3 = new Product(3, "Matelas", "Orthopédique", 50, 150.00f, 15.00f, 00.00f, 200);
//		productService.addProduct(p1);
//		productService.addProduct(p2);
//		productService.addProduct(p3);
	}

	@Test
	public void testUpdateProduct() throws ParseException {
		Product p = productRepository.findById(Long.parseLong("1")).get();
		p.setMaxQuantityProduct(200);
//		productService.updateProduct(p);
	}

	@Test
	public void testDeleteProduct() throws ParseException {
		productService.deleteProduct(3);
	}

	@Test
	public void testRetrieveAllProduct() throws ParseException {
		productService.retrieveAllProducts();
	}

	@Test
	public void testRetrieveProduct() throws ParseException {
		Product p = productRepository.findById(Long.parseLong("1")).get();
		productService.retrieveProduct(1).getClass();
	}

}
