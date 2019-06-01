package wad.cart.ramos.diaz.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import wad.cart.ramos.diaz.bs.UserBs;
import wad.cart.ramos.diaz.entidad.Address;
import wad.cart.ramos.diaz.entidad.User;

@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "users" }),
		   @Result(name = "login-users", type = "redirectAction", params = { "actionName", "login/users"})})
@InterceptorRef("customStack")
public class UsersAct {
	@Autowired
	private UserBs userBs;
	private Address address;
	private User model;
	private Integer idSel;
	
	private static final long serialVersionUID = 1L;
	
	public String index() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Integer idUser = (Integer) session.getAttribute("idUser");
		
		model = userBs.findById(idUser);
		address = model.getAddress();
		return "index";
	}
	
	@VisitorFieldValidator
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@VisitorFieldValidator
	public Integer getIdSel() {
		return idSel;
	}

	public void setIdSel(Integer idSel) {
		this.idSel = idSel;
	}

	public void setModel(User model) {
		this.model = model;
	}

	@VisitorFieldValidator
	public User getModel() {
		return model;
	}
	
}
