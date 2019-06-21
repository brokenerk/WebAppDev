package wad.cart.ramos.diaz.bs;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wad.cart.ramos.diaz.dao.ProductDao;
import wad.cart.ramos.diaz.entidad.OrderDetail;
import wad.cart.ramos.diaz.entidad.Product;

@Service("productBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ProductBs {
	@Autowired
	private ProductDao productDao;
	
	public Product calculateDiscount(Product p) {
		Float price = p.getPrice();
		Float discount = p.getDiscount();
		Float realPrice = price - (price * (discount / 100));
		DecimalFormat df = new DecimalFormat("#.##");
		p.setRealPrice(Float.valueOf(df.format(realPrice)));
		return p;
	}
	
	public List<OrderDetail> calculateRealPrice(List<OrderDetail> orderDetails){
		for(OrderDetail od: orderDetails) {
			Product p = od.getProduct();
			p = calculateDiscount(p);
		}
		return orderDetails;
	}

	public List<Product> findAllProducts() {
		List<Product> products = productDao.findAllProducts();
		//Precio con descuento
		for(Product p: products)
			p = calculateDiscount(p);
		return products;
	}
	
	public Product findById(Integer id) {
		return productDao.findById(id);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void updateStock(List<OrderDetail> orderDetails) {
		for(OrderDetail od: orderDetails) {
			Product p = findById(od.getIdProduct());
			p.setStock(p.getStock() - od.getAmount());
			productDao.updateStock(p);
		}
	}
}
