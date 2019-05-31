package wad.cart.ramos.diaz.bs;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import wad.cart.ramos.diaz.dao.ProductDao;
import wad.cart.ramos.diaz.entidad.OrderDetail;
import wad.cart.ramos.diaz.entidad.Product;
import wad.cart.ramos.diaz.entidad.User;

@Service("productBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ProductBs {
	
	@Autowired
	private ProductDao productDao;
	
	public Float calculateDiscount(Float price, Float discount) {
		Float realPrice = price - (price * (discount / 100));
		DecimalFormat df = new DecimalFormat("#.##");
		return Float.valueOf(df.format(realPrice));
	}
	
	public List<OrderDetail> calculateRealPrice(List<OrderDetail> orderDetails){
		for(OrderDetail od: orderDetails) {
			Product p = od.getProduct();
			Float realPrice = calculateDiscount(p.getPrice(), p.getDiscount());
			p.setRealPrice(realPrice);
		}
		return orderDetails;
	}

	public List<Product> findAllProducts() {
		List<Product> products = productDao.findAllProducts();
		//Precio con descuento
		for(Product p: products) {
			Float realPrice = calculateDiscount(p.getPrice(), p.getDiscount());
			p.setRealPrice(realPrice);
		}
		return products;
	}
	
	public Product findById(Integer id) {
		return productDao.findById(id);
	}

}
