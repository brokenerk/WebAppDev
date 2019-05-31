package wad.cart.ramos.diaz.action;

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
			@Result(name = "login", type = "redirectAction", params = { "actionName", "login" })})
@InterceptorRef(value="customStack")
public class UsersAct {
	@Autowired
	private UserBs userBs;
	private Address address;
	private User model;
	private Integer idSel;
	
	private static final long serialVersionUID = 1L;
	
	public String index() {
		model = userBs.findById(1);
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
