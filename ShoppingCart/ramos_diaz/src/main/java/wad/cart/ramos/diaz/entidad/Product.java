package wad.cart.ramos.diaz.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
	@Id
	@SequenceGenerator(name = "product_id_product_seq", sequenceName = "product_id_product_seq", allocationSize = 1)
	@GeneratedValue(generator = "product_id_product_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_product")
	private Integer id;
	@Column(name = "tx_name")
	private String name;
	@Column(name = "tx_description")
	private String description;
	@Column(name = "ft_price")
	private Float price;
	@Column(name = "nu_stock")
	private Integer stock;
	@Column(name = "ft_discount")
	private Float discount;
	@Transient
	protected Float realPrice;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Float getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(Float realPrice) {
		this.realPrice = realPrice;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getStock() {
		return stock;
	}
	
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
