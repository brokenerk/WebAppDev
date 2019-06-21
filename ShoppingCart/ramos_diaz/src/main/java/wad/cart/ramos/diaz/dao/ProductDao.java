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

@Repository("productDao")
public class ProductDao {
	@PersistenceContext
	private EntityManager entityManagerFactory;
	
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
	
	public Product findById(Integer id) {
		return entityManagerFactory.find(Product.class, id);
	}
	
	public void updateStock(Product p) {
		try {
			entityManagerFactory.merge(p);
		}
		catch(Exception e) {
			System.out.println("--------------> Error al actualizar stock del producto");
		}
	}
}
