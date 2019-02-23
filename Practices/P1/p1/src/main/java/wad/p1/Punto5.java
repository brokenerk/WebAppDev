package wad.p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Punto5
 */
public class Punto5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Conexion c;
	      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Punto5() {
        super();
        c = new Conexion("org.postgresql.Driver", "jdbc:postgresql://localhost/", "homework-6", "postgres", "postgres");
        c.conectarBD();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		c.mostrarRegistros();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
