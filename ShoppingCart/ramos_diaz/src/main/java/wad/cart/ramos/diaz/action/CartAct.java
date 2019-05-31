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

import wad.cart.ramos.diaz.bs.ProductBs;
import wad.cart.ramos.diaz.bs.UserBs;
import wad.cart.ramos.diaz.entidad.OrderC;
import wad.cart.ramos.diaz.entidad.OrderDetail;
import wad.cart.ramos.diaz.entidad.User;

@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "cart" }),
	       @Result(name = "login-cart", type = "redirectAction", params = { "actionName", "login/1"})})
@InterceptorRef(value="customStack")
public class CartAct {
	
	@Autowired
	private UserBs userBs;
	@Autowired
	private ProductBs productBs;
	private User model;
	private Integer idSel;
	private OrderC orders;
	private List<OrderDetail> orderDetails;
	
	private static final long serialVersionUID = 1L;

	public String index() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Integer idUser = (Integer) session.getAttribute("idUser");
		model = userBs.findById(idUser);
		orders = userBs.findCart(model.getOrders());
		orderDetails = productBs.calculateRealPrice(orders.getOrderDetails());
		return "index";
	}
	
	@VisitorFieldValidator
	public OrderC getOrders() {
		return orders;
	}

	public void setOrders(OrderC orders) {
		this.orders = orders;
	}
	
	@VisitorFieldValidator
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
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
