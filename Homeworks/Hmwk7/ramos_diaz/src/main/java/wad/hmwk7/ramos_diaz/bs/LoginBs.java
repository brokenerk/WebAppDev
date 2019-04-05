package wad.hmwk7.ramos_diaz.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import wad.hmwk7.ramos_diaz.dao.LoginDao;
import wad.hmwk7.ramos_diaz.entidad.User;

//Definir capa de negocio
@Service("loginBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class LoginBs {
	
	//Para usar el acceso a datos
	@Autowired
	private LoginDao loginDao;
	
	public User logIn(String username, String password) {
		//Acceso a datos
		User logedUser = loginDao.findUserByUsername(username);
		
		if(logedUser != null) {
			//El usuario existe
			if (logedUser.getPassword().equals(passwordDigest(password))) {
				//La contraseña es correcta
				//Asignamos el nombre completo
				logedUser.setFullName(logedUser.getName() + " " + logedUser.getLastName() + " " + logedUser.getSecondLastName());
				System.out.println("Usuario autenticado exitosamente");
			}
			else {
				//El usuario existe, pero la contraseña ingresada es incorrecta
				//Devolver nulo
				System.out.println("Contraseña incorrecta");
				logedUser = null;
			}
		}
		else {
			//El usuario no esta registrado, devolver nulo
			System.out.println("usuario no encontrado");
			logedUser = null;
		}
		//Devolver usuario, si cumple con la autentificacion
		return logedUser;
	}
	
	private static String passwordDigest(String password) {
		return password;
	}

}
