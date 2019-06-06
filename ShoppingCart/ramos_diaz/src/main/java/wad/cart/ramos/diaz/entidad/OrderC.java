package wad.cart.ramos.diaz.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "order_c")
@Inheritance(strategy = InheritanceType.JOINED)
public class OrderC {
	@Id
	@SequenceGenerator(name = "order_c_id_order_seq", sequenceName = "order_c_id_order_seq", allocationSize = 1)
	@GeneratedValue(generator = "order_c_id_order_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_order")
	private Integer id;
	@Column(name = "fh_date")
	private Date date;
	@Column(name = "st_purchased")
	private Boolean purchased;
	@Column(name = "ft_total")
	private Float total;
	@Column(name = "id_user")
	private Integer idUser;
	
	@OneToMany
	@JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
	private List<OrderDetail> orderDetails;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Boolean getPurchased() {
		return purchased;
	}

	public void setPurchased(Boolean purchased) {
		this.purchased = purchased;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
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
		OrderC other = (OrderC) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
