package wad.cart.ramos.diaz.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import wad.cart.ramos.diaz.dao.CreditCardDao;
import wad.cart.ramos.diaz.entidad.CreditCard;

@Service("creditCardBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class CreditCardBs {
	@Autowired
	private CreditCardDao creditCardDao;
	
	public CreditCard findById(Integer id) {
		return creditCardDao.findById(id);
	}

}
