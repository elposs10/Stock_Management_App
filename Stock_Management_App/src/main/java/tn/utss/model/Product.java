package tn.utss.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Products")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	public static final String SEQUENCE_NAME = "product_sequence";

	@Id
	private long idProduct;
	@Field(value = "ProductTitle")
	private String titleProduct;
	@Field(value = "ProductDescription")
	private String descriptionProduct;
	@Field(value = "ProductQuantity")
	private int quantityProduct;
	@Indexed(direction = IndexDirection.ASCENDING)
	@Field(value = "ProductPrice")
	private float priceProduct;
	@Field(value = "ProductWeight")
	private float weightProduct;
	@Indexed(direction = IndexDirection.ASCENDING)
	@Field(value = "ProductBuyingPrice")
	private float buyingPriceProduct;
	@Field(value = "ProductMaxQuantity")
	private int maxQuantityProduct;
	@Field(value = "ProductImage")
	private String imageProd;

	private SubCategory subCategory;

	private Stock stock;

	private List<Movement> productMovement;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(long idProduct, String titleProduct, String descriptionProduct, int quantityProduct,
			float priceProduct, float weightProduct, float buyingPriceProduct, int maxQuantityProduct, String imageProd,
			SubCategory subCategory, Stock stock, List<Movement> productMovement) {
		super();
		this.idProduct = idProduct;
		this.titleProduct = titleProduct;
		this.descriptionProduct = descriptionProduct;
		this.quantityProduct = quantityProduct;
		this.priceProduct = priceProduct;
		this.weightProduct = weightProduct;
		this.buyingPriceProduct = buyingPriceProduct;
		this.maxQuantityProduct = maxQuantityProduct;
		this.imageProd = imageProd;
		this.subCategory = subCategory;
		this.stock = stock;
		this.productMovement = productMovement;
	}

	public Product(String titleProduct, String descriptionProduct) {
		super();
		this.titleProduct = titleProduct;
		this.descriptionProduct = descriptionProduct;
	}

	public Product(long idProduct, String titleProduct, String descriptionProduct, int quantityProduct,
			float priceProduct, float weightProduct, float buyingPriceProduct, int maxQuantityProduct) {
		super();
		this.idProduct = idProduct;
		this.titleProduct = titleProduct;
		this.descriptionProduct = descriptionProduct;
		this.quantityProduct = quantityProduct;
		this.priceProduct = priceProduct;
		this.weightProduct = weightProduct;
		this.buyingPriceProduct = buyingPriceProduct;
		this.maxQuantityProduct = maxQuantityProduct;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public String getTitleProduct() {
		return titleProduct;
	}

	public void setTitleProduct(String titleProduct) {
		this.titleProduct = titleProduct;
	}

	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}

	public int getQuantityProduct() {
		return quantityProduct;
	}

	public void setQuantityProduct(int quantityProduct) {
		this.quantityProduct = quantityProduct;
	}

	public float getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(float priceProduct) {
		this.priceProduct = priceProduct;
	}

	public float getWeightProduct() {
		return weightProduct;
	}

	public void setWeightProduct(float weightProduct) {
		this.weightProduct = weightProduct;
	}

	public float getBuyingPriceProduct() {
		return buyingPriceProduct;
	}

	public void setBuyingPriceProduct(float buyingPriceProduct) {
		this.buyingPriceProduct = buyingPriceProduct;
	}

	public int getMaxQuantityProduct() {
		return maxQuantityProduct;
	}

	public void setMaxQuantityProduct(int maxQuantityProduct) {
		this.maxQuantityProduct = maxQuantityProduct;
	}

	public String getImageProd() {
		return imageProd;
	}

	public void setImageProd(String imageProd) {
		this.imageProd = imageProd;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public List<Movement> getProductMovement() {
		return productMovement;
	}

	public void setProductMovement(List<Movement> productMovement) {
		this.productMovement = productMovement;
	}

	@Override
	public int hashCode() {
		return Objects.hash(buyingPriceProduct, descriptionProduct, idProduct, imageProd, maxQuantityProduct,
				priceProduct, productMovement, quantityProduct, stock, subCategory, titleProduct, weightProduct);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Float.floatToIntBits(buyingPriceProduct) == Float.floatToIntBits(other.buyingPriceProduct)
				&& Objects.equals(descriptionProduct, other.descriptionProduct) && idProduct == other.idProduct
				&& Objects.equals(imageProd, other.imageProd) && maxQuantityProduct == other.maxQuantityProduct
				&& Float.floatToIntBits(priceProduct) == Float.floatToIntBits(other.priceProduct)
				&& Objects.equals(productMovement, other.productMovement) && quantityProduct == other.quantityProduct
				&& Objects.equals(stock, other.stock) && Objects.equals(subCategory, other.subCategory)
				&& Objects.equals(titleProduct, other.titleProduct)
				&& Float.floatToIntBits(weightProduct) == Float.floatToIntBits(other.weightProduct);
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", titleProduct=" + titleProduct + ", descriptionProduct="
				+ descriptionProduct + ", quantityProduct=" + quantityProduct + ", priceProduct=" + priceProduct
				+ ", weightProduct=" + weightProduct + ", buyingPriceProduct=" + buyingPriceProduct
				+ ", maxQuantityProduct=" + maxQuantityProduct + ", imageProd=" + imageProd + ", subCategory="
				+ subCategory + ", stock=" + stock + ", productMovement=" + productMovement + "]";
	}

}
