package wad.cart.ramos.diaz.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import wad.cart.ramos.diaz.bs.CreditCardBs;
import wad.cart.ramos.diaz.bs.UserBs;
import wad.cart.ramos.diaz.entidad.CardUser;
import wad.cart.ramos.diaz.entidad.CreditCard;
import wad.cart.ramos.diaz.entidad.User;

@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "credit-card" }),
	       @Result(name = "login-credit-card", type = "redirectAction", params = { "actionName", "login/2"})})
@InterceptorRef(value="customStack")
public class CreditCardAct {
	@Autowired
	private CreditCardBs creditCardBs;
	@Autowired
	private UserBs userBs;
	private User user;
	private CreditCard model;
	private List<CardUser> creditCards;
	private Integer idSel;
	
	private static final long serialVersionUID = 1L;
	
	public String index() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Integer idUser = (Integer) session.getAttribute("idUser");
		user = userBs.findById(idUser);
		creditCards = user.getCreditCards();
		return "index";
	}
	
	@VisitorFieldValidator
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
			model = creditCardBs.findById(idSel);
		}
	}

	public void setModel(CreditCard model) {
		this.model = model;
	}

	@VisitorFieldValidator
	public CreditCard getModel() {
		return model;
	}
	
}
