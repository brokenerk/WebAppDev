package wad.cart.ramos.diaz.action;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import io.conekta.Error;
import io.conekta.ErrorList;
import io.conekta.Order;
import wad.cart.ramos.diaz.bs.BuyBs;
import wad.cart.ramos.diaz.bs.OrderBs;
import wad.cart.ramos.diaz.bs.ProductBs;
import wad.cart.ramos.diaz.bs.UserBs;
import wad.cart.ramos.diaz.entidad.OrderC;
import wad.cart.ramos.diaz.entidad.OrderDetail;
import wad.cart.ramos.diaz.entidad.Product;
import wad.cart.ramos.diaz.entidad.User;

@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "buy" }),
			@Result(name = ActionSupport.INPUT, location="/pages/buy/index.jsp"),
			@Result(name = "login-buy", type = "redirectAction", params = { "actionName", "login/cart"})})
@InterceptorRef("customStack")
public class BuyAct extends ActionSupport{
	@Autowired
	private UserBs userBs;
	@Autowired
	private ProductBs productBs;
	@Autowired
	private OrderBs orderBs;
	@Autowired
	private BuyBs buyBs;
	private User model;
	private Integer idSel;
	private OrderC cart;
	private List<OrderDetail> orderDetails;
	private String conektaTokenId;
	
	private HttpSession session = ServletActionContext.getRequest().getSession();
	private Integer idUser = (Integer) session.getAttribute("idUser");
	
	private static final long serialVersionUID = 1L;
	
	public void findCart() {
		model = userBs.findById(idUser);
		cart = userBs.findCart(model.getOrders());
		if(cart != null) {
			cart = orderBs.formatTotal(cart);
			orderDetails = productBs.calculateRealPrice(cart.getOrderDetails());
		}
	}
	
	@SkipValidation
	public String index() {
		findCart();
		return "index";
	}
	
	public void validateCreate() {
		findCart();
		System.out.println("-------------->" + getConektaTokenId());
		List<OrderDetail> orderDetails = cart.getOrderDetails();
		Product p = orderDetails.get(0).getProduct();
		Boolean allAvailable = true;

		for(OrderDetail od: orderDetails) {
			p = od.getProduct();
			if(od.getAmount() > p.getStock()) {
				addFieldError("" + p.getId() + "", "The product " + p.getName() + " is out of stock. Try again later or reduce the amount");
				setIdSel(p.getId());
				System.out.println("The product is out of stock. Try again later or reduce the amount");
				allAvailable = false;
			}
		}
		
		if(allAvailable) {
			String json = buyBs.createOrder(cart.getId(), cart.getTotal(), model, p, getConektaTokenId());
			try {
				Order buy = buyBs.buy(json);
				System.out.println("------------>" + buy.charges.get(0));
			} catch (ErrorList e) {
				addFieldError("buyError", e.details.get(0).message);
			} catch (Error e) {
				e.printStackTrace();
			}
		}
	}
	
	public String create() {
		findCart();
		cart = orderBs.orderIsPurchased(cart);
		productBs.updateStock(orderDetails);
		return "create";
	}
	
	@VisitorFieldValidator
	public User getModel() {
		return model;
	}

	public void setModel(User model) {
		this.model = model;
	}
	
	@VisitorFieldValidator
	public Integer getIdSel() {
		return idSel;
	}

	public void setIdSel(Integer idSel) {
		this.idSel = idSel;
	}
	
	@VisitorFieldValidator
	public OrderC getCart() {
		return cart;
	}

	public void setCart(OrderC cart) {
		this.cart = cart;
	}
	
	@VisitorFieldValidator
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	@VisitorFieldValidator
	public Integer getIdUser() {
		return idUser;
	}
	
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
	@VisitorFieldValidator
	public String getConektaTokenId() {
		return conektaTokenId;
	}

	public void setConektaTokenId(String conektaTokenId) {
		this.conektaTokenId = conektaTokenId;
	}
}
