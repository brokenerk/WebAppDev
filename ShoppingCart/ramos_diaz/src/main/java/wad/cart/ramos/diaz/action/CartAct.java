package wad.cart.ramos.diaz.action;
import java.util.Date;
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
import wad.cart.ramos.diaz.entidad.Product;
import wad.cart.ramos.diaz.entidad.User;

@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "cart" }),
			@Result(name = "login-cart", type = "redirectAction", params = { "actionName", "login/cart"})})
@InterceptorRef("customStack")
public class CartAct {
	@Autowired
	private UserBs userBs;
	@Autowired
	private ProductBs productBs;
	@Autowired
	private OrderBs orderBs;
	private User model;
	private Integer idSel;
	private String operation;
	private OrderC cart;
	private List<OrderDetail> orderDetails;
	
	private HttpSession session = ServletActionContext.getRequest().getSession();
	private Integer idUser = (Integer) session.getAttribute("idUser");
	
	public void findCart() {
		model = userBs.findById(idUser);
		cart = userBs.findCart(model.getOrders());
		if(cart != null){
			cart = orderBs.formatTotal(cart);	
		}
	}

	public String index() {
		findCart();
		if(cart != null) {
			orderDetails = productBs.calculateRealPrice(cart.getOrderDetails());
		}
		return "index";
	}
	
	public String create() {
		//Obtenemos el producto
		Product newProduct = productBs.findById(idSel);
		newProduct = productBs.calculateDiscount(newProduct);
		findCart();
		Boolean firstTime = false;
		//Si no hay un carrito activo, lo agregamos
		if(cart == null) {
			Integer idNewCart = orderBs.createOrder(new Date(), newProduct.getRealPrice(), idUser);
			cart = orderBs.findById(idNewCart);
			firstTime = true;
		}
		
		//Intentamos agregar el producto
		Boolean added = orderBs.addProduct(newProduct, cart.getId(), 1);
		/*Si se agrego, actualizamos la orden, sino, acabamos. 
		Tambien revisamos si es el primer articulo en el carrito*/
		if(added && !firstTime) {
			cart = orderBs.updateOrder(newProduct.getRealPrice() + cart.getTotal(), cart);
		}
		return ActionSupport.SUCCESS;
	}
	
	public String update() {
		//Buscamos carrito y usuario
		findCart();
		//Buscamos producto
		Product p = productBs.findById(idSel);
		p = productBs.calculateDiscount(p);
		//Actualizamos la ordeDetail asociada
		Float newPrice = orderBs.updateAmount(p, cart.getId(), getOperation());
		//Actualizamos carrito
		cart = orderBs.updateOrder(newPrice, cart);
		//Si no hay productos, borramos
		if(cart.getOrderDetails().isEmpty())
			orderBs.deleteOrder(cart);
		
		return ActionSupport.SUCCESS;
	}
	
	public String destroy() {
		//Buscamos carrito y usuario
		findCart();
		//Buscamos producto
		Product p = productBs.findById(idSel);
		p = productBs.calculateDiscount(p);
		//Eliminamos orderDetail
		orderBs.removeProduct(p, cart.getId());
		
		Float newPrice = cart.getTotal() - p.getRealPrice();
		//Actualizamos la orden
		cart = orderBs.updateOrder(newPrice, cart);
		//Si no hay productos, eliminamos la orden
		if(cart.getOrderDetails().isEmpty())
			orderBs.deleteOrder(cart);
		
		return ActionSupport.SUCCESS;
	}

	@VisitorFieldValidator
	public OrderC getCart() {
		return cart;
	}

	public void setCart(OrderC cart) {
		this.cart = cart;
	}
	
	@VisitorFieldValidator
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
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
	
	@VisitorFieldValidator
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
}
