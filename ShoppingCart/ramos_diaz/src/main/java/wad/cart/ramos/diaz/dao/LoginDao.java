package wad.cart.ramos.diaz.dao;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import wad.cart.ramos.diaz.entidad.User;

//Definir capa de acceso a datos
@Repository("loginDao")
public class LoginDao {
	//Definir el entityManager
	@PersistenceContext
	private EntityManager entityManagerFactory;
	
	//Buscar por username unicamente
	public User findUserByUsername(String username) {
		User registeredUser = null;
		try {
			CriteriaBuilder criteriaBuilder = entityManagerFactory.getCriteriaBuilder();
			CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
			Root<User> root = criteriaQuery.from(User.class);
			
			//select * from users where login = username ...
			criteriaQuery.select(root);
			criteriaQuery.where(criteriaBuilder.equal(root.get("login"), username));
			Query query = entityManagerFactory.createQuery(criteriaQuery);
			//Obtener un unico resultados
			registeredUser = (User)query.getSingleResult();
		}
		catch(NoResultException nre) {
			//nre.printStackTrace();
			//Usuario no encontrado, devolver null
			registeredUser = null;
		}
		//Devolver usuario, si se encontro
		return registeredUser;
	}
}