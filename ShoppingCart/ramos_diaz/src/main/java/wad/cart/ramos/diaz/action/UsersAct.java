package wad.cart.ramos.diaz.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import wad.cart.ramos.diaz.bs.UserBs;
import wad.cart.ramos.diaz.entidad.User;

@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "users" }),
		   @Result(name = "login-users", type = "redirectAction", params = { "actionName", "login/users"}),
		   @Result(name = ActionSupport.INPUT, location="/pages/users/index-create.jsp")})
@InterceptorRef("customStack")
public class UsersAct extends ActionSupport implements ModelDriven<User>{
	@Autowired
	private UserBs userBs;
	private User model;
	private Integer idSel;
	private String confirmPassword;
	private HttpSession session = ServletActionContext.getRequest().getSession();
	private Integer idUser = (Integer) session.getAttribute("idUser");
	
	private static final long serialVersionUID = 1L;
	
	public String index() {
		model = userBs.findById(idUser);
		System.out.println("---------->index()");
		return "index";
	}

	public String create() {
		model = userBs.findById(idUser);
		System.out.println("---------->create()");
		return "create";
	}
	
	public void validateUpdate() {
		System.out.println("---------->validateUpdate()");
		if(confirmPassword.equals(""))
			addFieldError("confirmPassword", "Confirm password is mandatory");
		else if(!model.getPassword().equalsIgnoreCase(confirmPassword))
			addFieldError("confirmPassword", "Passwords doesn't match");
	}
	
	public String update() {
		System.out.println("---------->update()");
		model = userBs.updateUser(model);
		return ActionSupport.SUCCESS;
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

	@VisitorFieldValidator
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@VisitorFieldValidator
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
}
