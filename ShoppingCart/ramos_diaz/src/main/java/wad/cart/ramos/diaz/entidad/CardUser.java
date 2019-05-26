package wad.cart.ramos.diaz.entidad;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "card_users")
public class CardUser {
	@EmbeddedId
	private CardUserId id;
	@Column(name = "id_user", insertable = false, updatable = false)
	private Integer idUser;
	@Column(name = "id_credit_card", insertable = false, updatable = false)
	private Integer idCreditCard;
	
	@ManyToOne
	@JoinColumn(name = "id_credit_card", referencedColumnName = "id_credit_card", insertable = false, updatable = false)
	private CreditCard creditCard;
	
	public CardUser() {
		super();
	}

	public CardUser(Integer idUser, Integer idCreditCard) {
		super();
		this.idUser = idUser;
		this.idCreditCard = idCreditCard;
		this.id = new CardUserId(idUser, idCreditCard);
	}
	
	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
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
	
}
