package wad.cart.ramos.diaz.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import wad.cart.ramos.diaz.entidad.Product;
import wad.cart.ramos.diaz.entidad.User;

@Repository("pruebaDao")
public class PruebaDao {
	@PersistenceContext
	private EntityManager entityManagerFactory;

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		CriteriaBuilder criteriaBuilder = entityManagerFactory.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);
		Query query = entityManagerFactory.createQuery(criteriaQuery);
		List<User> users = query.getResultList();
		return users;
	}
	
	public User findById(Integer id) {
		return entityManagerFactory.find(User.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts() {
		CriteriaBuilder criteriaBuilder = entityManagerFactory.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
		Root<Product> root = criteriaQuery.from(Product.class);
		criteriaQuery.select(root);
		Query query = entityManagerFactory.createQuery(criteriaQuery);
		List<Product> products = query.getResultList();
		return products;
	}
	

}
