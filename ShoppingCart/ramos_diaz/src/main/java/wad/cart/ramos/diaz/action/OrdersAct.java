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

import wad.cart.ramos.diaz.bs.OrderBs;
import wad.cart.ramos.diaz.bs.ProductBs;
import wad.cart.ramos.diaz.bs.UserBs;
import wad.cart.ramos.diaz.entidad.OrderC;
import wad.cart.ramos.diaz.entidad.OrderDetail;
import wad.cart.ramos.diaz.entidad.User;

@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "orders" }),
	      @Result(name = "login-orders", type = "redirectAction", params = { "actionName", "login/orders"})})
@InterceptorRef("customStack")
public class OrdersAct {
	@Autowired
	private UserBs userBs;
	@Autowired
	private ProductBs productBs;
	@Autowired
	private OrderBs orderBs;
	private User model;
	private Integer idSel;
	private List<OrderC> orders;
	private OrderC order;
	private List<OrderDetail> orderDetails;
	HttpSession session = ServletActionContext.getRequest().getSession();
	Integer idUser = (Integer) session.getAttribute("idUser");

	
	public String index() {
		//Nos apoyamos de la sesion
		model = userBs.findById(idUser);
		orders = userBs.findOrders(model.getOrders());
		return "index";
	}
	
	public String show() {
		orderDetails = productBs.calculateRealPrice(getOrder().getOrderDetails());
		return "show";
	}
	
	public List<OrderC> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderC> orders) {
		this.orders = orders;
	}

	public OrderC getOrder() {
		return order;
	}

	public void setOrder(OrderC order) {
		this.order = order;
	}

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
		if (idSel != null)
			order = orderBs.findById(idSel);
	}

	public void setModel(User model) {
		this.model = model;
	}

	@VisitorFieldValidator
	public User getModel() {
		return model;
	}
	
	@VisitorFieldValidator
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
}
