package wad.p1;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class Conexion {
	String url;
	String user;
	String db;
	String driver;
	String password;
	Connection con;
	SimpleDateFormat sdf, sdf2;

	public Conexion(String driver, String url, String db, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.db = db;
		this.user = user;
		this.password = password;
		this.con = null;
		sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	}
	
	public void conectarBD() {
		try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + db,  user, password);
            con.setAutoCommit(false);
        }catch (Exception e) {
            System.out.println("Ocurrio un error : "+e.getMessage());
            System.exit(1);
        }
        System.out.println("La conexión se realizo sin problemas");
	}
	
	public void cerrarConexion() {
		try {
			con.close();
			System.out.println("Se cierra la conexion...");
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void mostrarUsuarios(PrintWriter out) {
		try {
			Statement stmt = null;
			stmt = con.createStatement();
	        ResultSet rsPerson = stmt.executeQuery(
	        		"SELECT p.*, u.tx_login " +
	        		"FROM person p, users u " +
	        		"WHERE u.id_user = p.id_person;");
	        
	        while (rsPerson.next()) {
	            out.println("<tr>");
				out.println("<td>" + rsPerson.getString("tx_first_name") + "</td>");
				out.println("<td>" + rsPerson.getString("tx_last_name_a") + "</td>");
				out.println("<td>" + rsPerson.getString("tx_last_name_b") + "</td>");
				out.println("<td>" + rsPerson.getString("tx_curp") + "</td>");
				out.println("<td>" + sdf.format(rsPerson.getDate("fh_birth")) + "</td>");
				out.println("<td>" + rsPerson.getString("tx_login") + "</td>");
				out.println("</tr>");
	        }
	        
	        rsPerson.close();
	        stmt.close();
	        System.out.println("Usuarios mostrados en tabla");
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}	
	
	public void registrarUsuarios(String firstName, String lastName, String secondName, String curp, String birthday, String login, String password) {
		try {
			Statement stmt2 = null;
			boolean registrar = true;
			stmt2 = con.createStatement();
	        ResultSet rsLogins = stmt2.executeQuery(
	        		"SELECT tx_login " +
	        		"FROM users u;");
	        
	        while(rsLogins.next()) {
	        	if(login.equals(rsLogins.getString("tx_login"))) {
	        		registrar = false;
	        	}
	        }
	        
	        if(registrar) {
	        	Statement stmt = null;
				int nextId = 1;
				stmt = con.createStatement();
				Date birth = new Date((sdf2.parse(birthday)).getTime()); 
				
				String addPerson = 
						"INSERT INTO person (tx_first_name, tx_last_name_a, tx_last_name_b, tx_curp, fh_birth) " +
						"VALUES ('" + firstName + "', '" + lastName + "', '" + secondName + "', '" + curp + "', '" + birth + "');";
				
				stmt.executeUpdate(addPerson);
		
				String getId = "SELECT id_person " +
		        		"FROM person " +
		        		"WHERE tx_curp = '" + curp + "';";
		
				ResultSet rsId = stmt.executeQuery(getId);
				
				if(rsId.next()) {
					nextId = rsId.getInt("id_person");
				}
				
				String addUser = 
						"INSERT INTO users (id_user, tx_login, tx_password) " +
						"VALUES (" + nextId + ", '" + login + "', '" + password + "');";
				
				stmt.executeUpdate(addUser);
		
		        stmt.close();
		        con.commit();
		        System.out.println("Registro insertado correctamente");
	        }
	        else {
	        	System.out.println("El usuario ya existe. No se registrará la información.");
	        	stmt2.close();
	        }
	        
			
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
