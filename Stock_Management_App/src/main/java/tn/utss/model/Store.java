package tn.utss.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Stores")
public class Store implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	public static final String SEQUENCE_NAME = "store_sequence";

	@Id
	private long idStore;
	@Indexed
	private String nameStore;
	@Indexed
	private String localisationStore;

	private Stock stock;

	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Store(long idStore, String nameStore, String localisationStore, Stock stock) {
		super();
		this.idStore = idStore;
		this.nameStore = nameStore;
		this.localisationStore = localisationStore;
		this.stock = stock;
	}

	public Store(String nameStore, String localisationStore) {
		super();
		this.nameStore = nameStore;
		this.localisationStore = localisationStore;
	}

	public long getIdStore() {
		return idStore;
	}

	public void setIdStore(long idStore) {
		this.idStore = idStore;
	}

	public String getNameStore() {
		return nameStore;
	}

	public void setNameStore(String nameStore) {
		this.nameStore = nameStore;
	}

	public String getLocalisationStore() {
		return localisationStore;
	}

	public void setLocalisationStore(String localisationStore) {
		this.localisationStore = localisationStore;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStore, localisationStore, nameStore, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		return idStore == other.idStore && Objects.equals(localisationStore, other.localisationStore)
				&& Objects.equals(nameStore, other.nameStore) && Objects.equals(stock, other.stock);
	}

	@Override
	public String toString() {
		return "Store [idStore=" + idStore + ", nameStore=" + nameStore + ", localisationStore=" + localisationStore
				+ ", stock=" + stock + "]";
	}

}
