package wad.cart.ramos.diaz.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import wad.cart.ramos.diaz.dao.LoginDao;
import wad.cart.ramos.diaz.bs.UserNotFoundException;
import wad.cart.ramos.diaz.entidad.User;

@Service("loginBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class LoginBs {
	//Para usar el acceso a datos
	@Autowired
	private LoginDao loginDao;
	String[] views = {"buy", "cart", "credit-card", "orders", "products", "users"};
	
	public String findView(String url) {
		String view = "";
		for(String v: views) {
			if(url.endsWith(v))
				view = v;
		}
		return view;
	}
	
	public User logIn(String username, String password) throws UserNotFoundException, WrongPasswordException {
		//Acceso a datos
		User logedUser = loginDao.findUserByUsername(username);
		
		if(logedUser != null) {
			//El usuario existe
			if (logedUser.getPassword().equals(passwordDigest(password))) {
				//La contraseña es correcta
				System.out.println("Usuario autenticado exitosamente");
				//Devolver usuario, si cumple con la autentificacion
				return logedUser;
			}
			else {
				//El usuario existe, pero la contraseña ingresada es incorrecta
				System.out.println("Contraseña incorrecta");
				throw new WrongPasswordException();
			}
		}
		else {
			//El usuario no esta registrado, devolver nulo
			System.out.println("Usuario no encontrado");
			throw new UserNotFoundException();
		}	
	}
	
	private static String passwordDigest(String password) {
		return password;
	}
}
