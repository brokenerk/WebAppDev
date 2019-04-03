package wad.hmwk7.ramos_diaz.bs;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("usersTableBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class UsersTableBs {

	public UsersTableBs() {
		// TODO Auto-generated constructor stub
	}

}
