package wad.cart.ramos.diaz.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import wad.cart.ramos.diaz.bs.UserBs;
import wad.cart.ramos.diaz.entidad.Address;
import wad.cart.ramos.diaz.entidad.OrderC;
import wad.cart.ramos.diaz.entidad.OrderDetail;
import wad.cart.ramos.diaz.entidad.User;

@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "users" }) })
public class UsersAct {
	@Autowired
	private UserBs userBs;
	private Address address;
	private User model;
	private Integer idSel;
	private List<OrderC> orders;
	
	private static final long serialVersionUID = 1L;
	
	public String show() {
		address = model.getAddress();
		return "show";
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
