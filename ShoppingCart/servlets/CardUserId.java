package wad.cart.ramos.diaz.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CardUserId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_user", nullable = false)
	private Integer idUser;
	@Column(name = "id_credit_card", nullable = false)
	private Integer idCreditCard;
	
	public CardUserId() {
	}
	
	public CardUserId(Integer idUser, Integer idCreditCard) {
		super();
		this.idUser = idUser;
		this.idCreditCard = idCreditCard;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdCreditCard() {
		return idCreditCard;
	}

	public void setIdCreditCard(Integer idCreditCard) {
		this.idCreditCard = idCreditCard;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCreditCard == null) ? 0 : idCreditCard.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
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
		CardUserId other = (CardUserId) obj;
		if (idCreditCard == null) {
			if (other.idCreditCard != null)
				return false;
		} else if (!idCreditCard.equals(other.idCreditCard))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}
	
	

}
