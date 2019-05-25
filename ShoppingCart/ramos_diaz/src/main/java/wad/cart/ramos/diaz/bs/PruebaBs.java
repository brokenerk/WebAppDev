package wad.cart.ramos.diaz.bs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import wad.cart.ramos.diaz.dao.PruebaDao;
import wad.cart.ramos.diaz.entidad.Product;
import wad.cart.ramos.diaz.entidad.User;

@Service("pruebaBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class PruebaBs {

	@Autowired
	private PruebaDao pruebaDao;
	
	public List<User> findAllUsers() {
		return pruebaDao.findAllUsers();
	}
	
	public User findById(Integer id) {
		return pruebaDao.findById(id);
	}
	
	public List<Product> findAllProducts() {
		return pruebaDao.findAllProducts();
	}

}
