package wad.cart.ramos.diaz.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "credit_card")
@Inheritance(strategy = InheritanceType.JOINED)
public class CreditCard {
	@Id
	@SequenceGenerator(name = "credit_card_id_credit_card_seq", sequenceName = "credit_card_id_credit_card_seq", allocationSize = 1)
	@GeneratedValue(generator = "credit_card_id_credit_card_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_credit_card")
	private Integer id;
	@Column(name = "tx_number")
	private String number;
	@Column(name = "tx_owner")
	private String owner;
	@Column(name = "fh_expiration")
	private Date expiration;
	@Column(name = "tx_street")
	private String street;
	@Column(name = "tx_city")
	private String city;
	@Column(name = "tx_state")
	private String state;
	@Column(name = "tx_zipcode")
	private String zipCode;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public Date getExpiration() {
		return expiration;
	}
	
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
		CreditCard other = (CreditCard) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
