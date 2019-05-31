package wad.cart.ramos.diaz.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import wad.cart.ramos.diaz.bs.LoginBs;
import wad.cart.ramos.diaz.entidad.User;

@Results({ 
	@Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "login" }), 
	@Result(name = "cart", type = "redirectAction", params = { "actionName", "cart" }),
	@Result(name = "credit-card", type = "redirectAction", params = { "actionName", "credit-card" }),
	@Result(name = "orders", type = "redirectAction", params = { "actionName", "orders" }),
	@Result(name = "products", type = "redirectAction", params = { "actionName", "products" }),
	@Result(name = "users", type = "redirectAction", params = { "actionName", "users" })})
public class LoginAct{
	@Autowired
	private LoginBs loginBs;
	private User model;
	private String username;
	private String password;
	private HashMap<Integer, String> views = new HashMap<>();
	private Integer idSel;
	
	private static final long serialVersionUID = 1L;
	
	public String show() {
		return "show";
	}
	
	public String create() {
		views = loginBs.fillViews(views);
		Integer idUser = loginBs.logIn(getUsername(), getPassword());
		ServletActionContext.getRequest().getSession().setAttribute("idUser", idUser);
		return views.get(getIdSel());
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
	public HashMap<Integer, String> getViews() {
		return views;
	}

	public void setViews(HashMap<Integer, String> views) {
		this.views = views;
	}
	
	@VisitorFieldValidator
	public Integer getIdSel() {
		return idSel;
	}

	public void setIdSel(Integer idSel) {
		this.idSel = idSel;
	}
}
