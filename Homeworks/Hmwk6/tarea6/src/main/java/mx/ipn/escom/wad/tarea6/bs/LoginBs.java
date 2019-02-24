package mx.ipn.escom.wad.tarea6.bs;

import mx.ipn.escom.wad.tarea6.dao.LoginDao;
import mx.ipn.escom.wad.tarea6.entidad.Acceso;
import mx.ipn.escom.wad.tarea6.entidad.Cuenta;
import mx.ipn.escom.wad.tarea6.entidad.Usuario;
import mx.ipn.escom.wad.tarea6.exception.UserBlockedException;
import mx.ipn.escom.wad.tarea6.exception.UserNotFoundException;

public class LoginBs {
	public static Cuenta login(String username, String password) throws UserNotFoundException, UserBlockedException {
		Cuenta cuenta = LoginDao.buscarUsuarioByUsername(username);
		Usuario usuario = null;
		
		//Revisamos que exista la cuenta asociada al usuario
		if (cuenta != null) {
			//Obtenemos la info de usuario de la cuenta
			usuario = cuenta.getUsuario();
			//Revisamos que las contraseñas coincidan
			if (usuario.getPassword().equals(passwordDigest(password))) {
				Acceso acceso = usuario.getAcceso();
				if (!verificarBloqueoUsuario(acceso)) {
					throw new UserBlockedException();
				} else {
					System.out.println("usuario autenticado exitosamente");
				}
			} else {
				//Contraseña incorrecta
				registrarIntentoFallido(usuario);
				System.out.println("contraseña incorrecta");
				usuario = null;
				throw new UserNotFoundException();
			}
		} else {
			//Usuario no existe o es incorrecto
			System.out.println("usuario no encontrado");
			throw new UserNotFoundException();
		}
		//Retornamos el objeto cuenta
		return cuenta;
	}

	private static void registrarIntentoFallido(Usuario usuario) {
		
	}
	
	private static Boolean verificarBloqueoUsuario(Acceso acceso) {
		return true;
	}
	
	private static String passwordDigest(String password) {
		return password;
	}
}
