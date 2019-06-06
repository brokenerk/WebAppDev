package wad.cart.ramos.diaz.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import wad.cart.ramos.diaz.bs.UserBs;
import wad.cart.ramos.diaz.entidad.User;

@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "login/products" }),
	       @Result(name = ActionSupport.INPUT, location="/pages/register/index.jsp")})
public class RegisterAct extends ActionSupport implements ModelDriven<User>{
	@Autowired
	private UserBs userBs;
	private User model = new User();
	private String confirmPassword;
	private HttpSession session = ServletActionContext.getRequest().getSession();
	private Integer idUser = (Integer) session.getAttribute("idUser");
	
	private static final long serialVersionUID = 1L;
	
	@SkipValidation
	public String index() {
		return "index";
	}
	
	public void validateCreate() {
		if(confirmPassword.equals(""))
			addFieldError("confirmPassword", "Confirm password is mandatory");
		else if(!model.getPassword().equalsIgnoreCase(confirmPassword))
			addFieldError("confirmPassword", "Passwords doesn't match");
	}
	
	public String create() {
		userBs.addUser(model);
		return SUCCESS;
	}
	
	@VisitorFieldValidator
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@VisitorFieldValidator
	public User getModel() {
		return model;
	}

	public void setModel(User model) {
		this.model = model;
	}
	
	@VisitorFieldValidator
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
}
