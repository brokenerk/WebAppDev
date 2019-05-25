package wad.cart.ramos.diaz.entidad;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
	@EmbeddedId
	private OrderDetailId id;
	@Column(name = "id_product", insertable = false, updatable = false)
	private Integer idProduct;
	@Column(name = "id_order", insertable = false, updatable = false)
	private Integer idOrder;
	@Column(name = "nu_amount")
	protected Integer amount;

	@ManyToOne
	@JoinColumn(name = "id_product", referencedColumnName = "id_product", insertable = false, updatable = false)
	private Product product;
	
	public OrderDetail() {
		super();
	}

	public OrderDetail(Integer idProduct, Integer idOrder) {
		super();
		this.idProduct = idProduct;
		this.idOrder = idOrder;
		this.id = new OrderDetailId(idProduct, idOrder);
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
