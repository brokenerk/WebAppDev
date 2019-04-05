package wad.hmwk7.ramos_diaz.bs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wad.hmwk7.ramos_diaz.dao.UsersTableDao;
import wad.hmwk7.ramos_diaz.entidad.User;

//Definir capa de negocio
@Service("usersTableBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class UsersTableBs {
	
	//Para usar el acceso a datos
	@Autowired
	private UsersTableDao usersTableDao;

	//Buscar todos los usuarios en la bd
	public List<User> findAllUsers() {
		return usersTableDao.findAllUsers();
	}
	
	//Ingresar nuevo usuario, rollback en caso de errores
	@Transactional(rollbackFor = Exception.class)
	public void addUser(String firstName, String lastName, String secondName, String curp, String birthday, String login, String password, String confirmPassword) {
		try {
			//Revisamos que coincidan ambas contraseñas
			if(confirmPassword.equals(password)) {
				//Le damos formato a la fecha
				Date birth = new Date((new SimpleDateFormat("yyyy-MM-dd").parse(birthday)).getTime());
				//Acceso a datos
				usersTableDao.addUser(firstName, lastName, secondName, curp, birth, login, password);
			}
			else {
				System.out.println("Las contraseñas no coinciden. Intente de nuevo");
			}
		}catch(ParseException pe) {
			pe.printStackTrace();
			System.out.println("Problema al dar formato a la fecha");
		}
	}
}
