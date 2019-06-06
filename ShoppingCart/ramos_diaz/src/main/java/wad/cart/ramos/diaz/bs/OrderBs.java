package wad.cart.ramos.diaz.bs;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wad.cart.ramos.diaz.dao.OrderDao;
import wad.cart.ramos.diaz.entidad.OrderC;
import wad.cart.ramos.diaz.entidad.OrderDetail;
import wad.cart.ramos.diaz.entidad.Product;


@Service("orderBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class OrderBs {

	@Autowired
	private OrderDao orderDao;
	
	public OrderC findById(Integer id) {
		return orderDao.findById(id);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Integer createOrder(Date date, Float total, Integer idUser) {
		return orderDao.createOrder(date, total, idUser);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public OrderC updateOrder(Float price, OrderC order){
		return orderDao.updateOrder(price, order);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void deleteOrder(OrderC order) {
		orderDao.deleteOrder(order);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public OrderC orderIsPurchased(OrderC order) {
		return orderDao.orderIsPurchased(order);
	}
	
	public OrderC formatTotal(OrderC order) {
		DecimalFormat df = new DecimalFormat("#.##");
		order.setTotal(Float.valueOf(df.format(order.getTotal())));
		return order;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public boolean addProduct(Product product, Integer idOrder, Integer amount){
		Boolean exists = false;
		List<OrderDetail> orderDetails = findById(idOrder).getOrderDetails();
		
		for(OrderDetail od: orderDetails) {
			Integer idProduct = od.getIdProduct();
			if(idProduct == product.getId()) {
				exists = true;
				System.out.println("----------->El producto ya esta en el carrito. No agregamos");
				break;
			}
		}
		
		if(!exists) {
			orderDao.addProduct(product, idOrder, amount);
			return true;
		}
		else
			return false;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void removeProduct(Product p, Integer idOrder) {
		orderDao.removeProduct(p, idOrder);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Float updateAmount(Product p, Integer idOrder, String operation) {
		return orderDao.updateAmount(p, idOrder, operation);
	}
}
