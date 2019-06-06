package wad.cart.ramos.diaz.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import wad.cart.ramos.diaz.bs.LoginBs;
import wad.cart.ramos.diaz.bs.UserNotFoundException;
import wad.cart.ramos.diaz.bs.WrongPasswordException;
import wad.cart.ramos.diaz.entidad.User;

@Results({ 
	@Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "login" }), 
	@Result(name = ActionSupport.INPUT, location="/pages/login/index-show.jsp"),
	@Result(name = "cart", type = "redirectAction", params = { "actionName", "cart" }),
	@Result(name = "credit-card", type = "redirectAction", params = { "actionName", "credit-card" }),
	@Result(name = "orders", type = "redirectAction", params = { "actionName", "orders" }),
	@Result(name = "products", type = "redirectAction", params = { "actionName", "products" }),
	@Result(name = "users", type = "redirectAction", params = { "actionName", "users" })})
public class LoginAct extends ActionSupport {
	@Autowired
	private LoginBs loginBs;
	private User model;
	private String username;
	private String password;
	private String idSel;
	
	private static final long serialVersionUID = 1L;
	
	public String show() {
		return "show";
	}
	
	public void validateCreate() {
		idSel = getIdSel();
		try {
			model = loginBs.logIn(getUsername(), getPassword());
			Integer idUser = model.getId();
			ServletActionContext.getRequest().getSession().setAttribute("idUser", idUser);
		}
		catch(UserNotFoundException ex1) {
			addFieldError("username", "Username is wrong");
		}
		catch(WrongPasswordException ex2) {
			addFieldError("password", "Password is wrong");
		}
		finally {	
		}
	}
	
	public String create() {
		idSel = getIdSel();
		return idSel;
	}
	
	public String destroy() {
		ServletActionContext.getRequest().getSession().setAttribute("idUser", null);
		ServletActionContext.getRequest().getSession().invalidate();
		idSel = getIdSel();
		return idSel;
	}
	
	@VisitorFieldValidator
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@VisitorFieldValidator
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@VisitorFieldValidator
	public User getModel() {
		return model;
	}

	public void setModel(User model) {
		this.model = model;
	}
	
	@VisitorFieldValidator
	public String getIdSel() {
		return idSel;
	}

	public void setIdSel(String idSel) {
		this.idSel = idSel;
	}
}
