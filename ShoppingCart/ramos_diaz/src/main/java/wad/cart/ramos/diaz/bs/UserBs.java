package wad.cart.ramos.diaz.bs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import wad.cart.ramos.diaz.dao.UserDao;
import wad.cart.ramos.diaz.entidad.OrderC;
import wad.cart.ramos.diaz.entidad.User;

@Service("userBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class UserBs {
	@Autowired
	private UserDao userDao;
	
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}
	
	public OrderC findOrderById(Integer id) {
		return userDao.findOrderById(id);
	}
	
	public User findById(Integer id) {
		return userDao.findById(id);
	}
	
	public OrderC findCart(List<OrderC> orders){
		OrderC order = null;
		for(OrderC o: orders) {
			if(!o.getPurchased()) {
				order = o;
			}
		}
		return order;
	}
	
	public List<OrderC> findOrders(List<OrderC> orders){
		List<OrderC> order = new ArrayList<OrderC>();
		for(OrderC o: orders) {
			if(o.getPurchased()) {
				order.add(o);
			}
		}
		return order;
	}
}
