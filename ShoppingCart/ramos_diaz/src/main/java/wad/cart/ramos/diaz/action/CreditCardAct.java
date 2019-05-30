package wad.cart.ramos.diaz.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import wad.cart.ramos.diaz.bs.UserBs;
import wad.cart.ramos.diaz.entidad.CardUser;
import wad.cart.ramos.diaz.entidad.User;

@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "credit-card" }) })
public class CreditCardAct {
	@Autowired
	private UserBs userBs;
	private User model;
	private List<CardUser> creditCards;
	private Integer idSel;
	
	private static final long serialVersionUID = 1L;
	
	public String show() {
		creditCards = model.getCreditCards();
		return "show";
	}

	@VisitorFieldValidator
	public List<CardUser> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CardUser> creditCards) {
		this.creditCards = creditCards;
	}

	@VisitorFieldValidator
	public Integer getIdSel() {
		return idSel;
	}

	public void setIdSel(Integer idSel) {
		this.idSel = idSel;
		if (idSel != null) {
			model = userBs.findById(idSel);
		}
	}

	public void setModel(User model) {
		this.model = model;
	}

	@VisitorFieldValidator
	public User getModel() {
		return model;
	}
	
}
