package wad.cart.ramos.diaz.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import wad.cart.ramos.diaz.entidad.CreditCard;

@Repository("creditCardDao")
public class CreditCardDao {
	@PersistenceContext
	private EntityManager entityManagerFactory;
	
	public CreditCard findById(Integer id) {
		return entityManagerFactory.find(CreditCard.class, id);
	}

}
