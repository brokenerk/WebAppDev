package wad.cart.ramos.diaz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import wad.cart.ramos.diaz.entidad.Access;
import wad.cart.ramos.diaz.entidad.User;

@Repository("userDao")
public class UserDao {
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
	
	public void addUser(User u) {
		try {
			entityManagerFactory.persist(u);
			Access a = new Access();
			a.setId(u.getId());
			a.setAttempt(0);
			entityManagerFactory.persist(a);
			entityManagerFactory.flush();
		}
		catch(Exception e) {
			System.out.println("Error al registrar nuevo usuario");
		}
		finally {}
	}
	
	public User updateUser(User user) {
		User u = null;
		try {
			u = entityManagerFactory.merge(user);
		}
		catch(Exception e) {
			System.out.println("Error al registrar nuevo usuario");
		}
		finally {
		}
		return u;
	}
}
