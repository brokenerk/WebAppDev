package wad.p1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

public class Conexion {
	String url;
	String user;
	String db;
	String driver;
	String password;
	Connection con;

	public Conexion(String driver, String url, String db, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.db = db;
		this.user = user;
		this.password = password;
		this.con = null;
	}
	
	public void conectarBD() {
		try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + db,  user, password);
            con.setAutoCommit(false);
        } catch (Exception e) {
            System.out.println("Ocurrio un error : "+e.getMessage());
            System.exit(1);
        }
		
        System.out.println("La conexión se realizo sin problemas! =) ");
	}
	
	public Connection getConexion() {
		return this.con;
	}
	
	public void mostrarRegistros() {
		try {
			Statement stmt = null;
			stmt = con.createStatement();
			
	        ResultSet rsPerson = stmt.executeQuery("SELECT p.*, u.tx_login FROM person p, users u WHERE u.id_user = p.id_person;");
	        
	        while (rsPerson.next()) {
	        	int idPerson = rsPerson.getInt("id_person");
	            String nickname = rsPerson.getString("tx_login");
	            String firstName = rsPerson.getString("tx_first_name");
	            String lastName = rsPerson.getString("tx_last_name_a");
	            String secondName = rsPerson.getString("tx_last_name_b");
	            String curp = rsPerson.getString("tx_curp");
	            Date birthday = rsPerson.getDate("fh_birth");
	            
	            System.out.println("ID = " + idPerson);
	            System.out.println("FIRST NAME = " + firstName);
	            System.out.println("LAST NAME = " + lastName);
	            System.out.println("SECOND NAME = " + secondName);
	            System.out.println("CURP = " + curp);
	            System.out.println("BIRTHDAY = " + birthday);
	            System.out.println("NICKNAME = " + nickname);
	            System.out.println("");
	        }
	        rsPerson.close();
	        stmt.close();
	        //con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
