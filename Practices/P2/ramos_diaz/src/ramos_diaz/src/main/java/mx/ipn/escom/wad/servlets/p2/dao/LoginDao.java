package mx.ipn.escom.wad.servlets.p2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mx.ipn.escom.wad.servlets.p2.entidad.Cuenta;
import mx.ipn.escom.wad.servlets.p2.entidad.Persona;
import mx.ipn.escom.wad.servlets.p2.entidad.Rol;
import mx.ipn.escom.wad.servlets.p2.entidad.Usuario;

public class LoginDao {
	public static Cuenta buscarUsuarioByUsername(String username) {
		Usuario usuario;
		Persona persona;
		Rol rol;
		Cuenta cuenta;

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/homework-6", "postgres", "postgres");
			if (connection != null) {


				// Ingresar código para búsqueda del usuario con base en el username
				String sqlUsers = "SELECT * FROM users " +
								  "WHERE tx_login = '" + username + "';";
				PreparedStatement preparedStatementU = connection.prepareStatement(sqlUsers);
				ResultSet resultsetUsers = preparedStatementU.executeQuery();
				
				if(resultsetUsers.next()) {
					usuario = new Usuario();
					usuario.setPassword(resultsetUsers.getString("tx_password"));
				}
				else {
					usuario = null;
				}
				
				int Id = resultsetUsers.getInt("id_user");
				
				// Ingresar código para búsqueda de la persona con base en el usuario
				String sqlPerson = "SELECT * FROM person " +
								   "WHERE id_person = '" + Id + "';";
				PreparedStatement preparedStatementP = connection.prepareStatement(sqlPerson);
				ResultSet resultsetPerson = preparedStatementP.executeQuery();
				
				if(resultsetPerson.next()) {
					persona = new Persona();
					persona.setNombre(resultsetPerson.getString("tx_first_name"));
					persona.setPrimerApellido(resultsetPerson.getString("tx_last_name_a"));
					persona.setSegundoApellido(resultsetPerson.getString("tx_last_name_b"));
				}
				else {
					persona = null;
				}
				
				// Ingresar código para búsqueda del rol con base en el usuario
				String sqlRol = "SELECT r.nb_role, r.ds_role FROM role r, account a " + 
						"WHERE r.id_role = a.id_role " + 
						"AND a.id_user = " + Id + ";";
				
				PreparedStatement preparedStatementR = connection.prepareStatement(sqlRol);
				ResultSet resultsetRol = preparedStatementR.executeQuery();
				
				if(resultsetRol.next()) {
					rol = new Rol();
					cuenta = new Cuenta();
					rol.setNombre(resultsetRol.getString("nb_role"));
					rol.setDescripcion(resultsetRol.getString("ds_role"));
				}
				else {
					rol = null;
					cuenta = null;
				}
				
				// Crear la cuenta de la sesion actual, son su respectivo usuario, persona y rol
				cuenta.setUsuario(usuario);
				cuenta.setRol(rol);
				
				// Relacionar el usuario con su persona
				persona.setUsuario(usuario);
				usuario.setPersona(persona);
				
				resultsetUsers.close();
				preparedStatementU.close();
				resultsetPerson.close();
				preparedStatementP.close();	
			} else {
				// Error al conectarse a la base de datos
				cuenta = null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			cuenta = null;
		} catch (SQLException e) {
			e.printStackTrace();
			cuenta = null;
		} finally {

		}
		return cuenta;
	}
}
