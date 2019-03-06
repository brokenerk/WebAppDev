package mx.ipn.escom.wad.servlets.p2.userstable;
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
	}
	
	public void cerrarConexion() {
		try {
			con.close();
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
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}	
}
