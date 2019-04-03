package wad.hmwk7.ramos_diaz.bs;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import wad.hmwk7.ramos_diaz.dao.UsersTableDao;
import wad.hmwk7.ramos_diaz.entidad.User;

@Service("usersTableBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class UsersTableBs {

	@Autowired
	private UsersTableDao usersTableDao;

	public List<User> findAllUsers() {
		return usersTableDao.findAllUsers();
	}

}
