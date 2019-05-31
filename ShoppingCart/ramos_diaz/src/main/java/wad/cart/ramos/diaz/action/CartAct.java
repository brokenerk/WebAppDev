package wad.cart.ramos.diaz.action;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import wad.cart.ramos.diaz.bs.ProductBs;
import wad.cart.ramos.diaz.bs.UserBs;
import wad.cart.ramos.diaz.entidad.OrderC;
import wad.cart.ramos.diaz.entidad.OrderDetail;
import wad.cart.ramos.diaz.entidad.Product;
import wad.cart.ramos.diaz.entidad.User;

@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "cart" }) })
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
		model = userBs.findById(1);
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
