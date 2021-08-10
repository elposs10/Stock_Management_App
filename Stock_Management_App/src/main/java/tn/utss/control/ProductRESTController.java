package tn.utss.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.utss.model.Product;
import tn.utss.service.ProductServiceImpl;

@RestController
@RequestMapping("/utss/tn")
public class ProductRESTController {

	@Autowired
	ProductServiceImpl serviceProduct;

	@GetMapping("/AllProducts")
	public List<Product> getAllProducts() {
		List<Product> list = serviceProduct.retrieveAllProducts();
		return list;
	}

	@GetMapping("/OneProduct/{idProduct}")
	@ResponseBody
	public Product getOneProduct(@PathVariable("idProduct") long idProduct) {

		return serviceProduct.retrieveProduct(idProduct);

	}

	@PostMapping(value = "/addProduct")
	public Product addProduct(@RequestBody Product Product) {
		serviceProduct.addProduct(Product);
		return Product;

	}

	@PutMapping(value = "/updateProduct")
	public Product updateProduct(@RequestBody Product Product) {
		return serviceProduct.updateProduct(Product);

	}

	@DeleteMapping(value = "/deleteProduct/{idProduct}")
	public void deleteProduct(@PathVariable("idProduct") long idProduct) {
		serviceProduct.deleteProduct(idProduct);
	}
}
