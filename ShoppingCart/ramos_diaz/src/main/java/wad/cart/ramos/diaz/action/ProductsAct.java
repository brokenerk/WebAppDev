package wad.cart.ramos.diaz.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import wad.cart.ramos.diaz.bs.ProductBs;
import wad.cart.ramos.diaz.entidad.Product;

@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "products" }) })
public class ProductsAct {
	
	@Autowired
	private ProductBs productBs;
	private List<Product> listProducts;
	private Integer idSel;
	private Product model;
	
	private static final long serialVersionUID = 1L;

	public String index() {
		listProducts = productBs.findAllProducts();
		return "products";
	}
	
	public String show() {
		return "show";
	}
	
	@VisitorFieldValidator
	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}
	
	@VisitorFieldValidator
	public Integer getIdSel() {
		return idSel;
	}

	public void setIdSel(Integer idSel) {
		this.idSel = idSel;
		if (idSel != null) {
			model = productBs.findById(idSel);
			//Añadimos el precio sin descuento
			Float realPrice = productBs.calculateDiscount(model.getPrice(), model.getDiscount());
			model.setRealPrice(realPrice);
		}
	}
	
	@VisitorFieldValidator
	public Product getModel() {
		return model;
	}

	public void setModel(Product model) {
		this.model = model;
	}
}

