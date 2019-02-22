package wad.p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Punto5
 */
public class Punto5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conex = null;
	
	private void realizaConexion(){
        String urlDatabase =  "jdbc:postgresql://localhost/homework-6";
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection(urlDatabase,  "postgres", "postgres");
        } catch (Exception e) {
            System.out.println("Ocurrio un error : "+e.getMessage());
            System.exit(1);
        }
        System.out.println("La conexión se realizo sin problemas! =) ");
	}
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Punto5() {
        super();
        realizaConexion();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
