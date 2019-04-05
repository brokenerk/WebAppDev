package wad.hmwk7.ramos_diaz.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import wad.hmwk7.ramos_diaz.entidad.Access;
import wad.hmwk7.ramos_diaz.entidad.Account;
import wad.hmwk7.ramos_diaz.entidad.Address;
import wad.hmwk7.ramos_diaz.entidad.User;

//Capa de acceso a datos
@Repository("usersTableDao")
public class UsersTableDao {
	//Definimos el entityManager
	@PersistenceContext
	private EntityManager entityManagerFactory;

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		//Buscamos todos los usuarios
		List<User> users;
		try {
			CriteriaBuilder criteriaBuilder = entityManagerFactory.getCriteriaBuilder();
			CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
			Root<User> root = criteriaQuery.from(User.class);
			//select * from users ...
			criteriaQuery.select(root);
			Query query = entityManagerFactory.createQuery(criteriaQuery);
			users = query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error al consultar los usuarios");
			users = null;
		}
		return users;
	}
	
	public void addUser(String firstName, String lastName, String secondName, String curp, Date birthday, String login, String password) {
		try {
			//Creamos una nueva entidad user
			User u = new User();
			u.setName(firstName);
			u.setLastName(lastName);
			u.setSecondLastName(secondName);
			u.setCurp(curp);
			u.setBirthDay(birthday);
			u.setLogin(login);
			u.setPassword(password);
			//Insertamos en la bd con persist
			//insert into users ...
			entityManagerFactory.persist(u);
			entityManagerFactory.flush();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error al agregar usuario");
		}
	}
}
