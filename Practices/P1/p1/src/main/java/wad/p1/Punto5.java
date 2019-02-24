package wad.p1;

import java.io.IOException;
import java.io.PrintWriter;
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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Table X</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Users</h2>");
		out.println("<table border='2'>");
		out.println("<tr>");
		out.println("<th>First Name (job title)</th>");
		out.println("<th>Last Name</th>");
		out.println("<th>Second Last Name</th>");
		out.println("<th>CURP</th>");
		out.println("<th>Birthday</th>");
		out.println("<th>Nickname</th>");
		out.println("</tr>");
		
		c.conectarBD();
		c.mostrarUsuarios(out);
		c.cerrarConexion();
		
		out.println("</table>");
        out.println("<br>");
        out.println("<a href='punto5-2.jsp'><button>New</button></a>");
        out.println("<a href='index.jsp'><button>Home</button></a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String secondName = request.getParameter("secondName");
		String curp = request.getParameter("curp");
		String birthday = request.getParameter("birthday");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(secondName);
		System.out.println(curp);
		System.out.println(birthday);
		System.out.println(login);
		System.out.println(password);
		System.out.println(confirmPassword);
		
		if(confirmPassword.equals(password)) {
			c.conectarBD();
			c.registrarUsuarios(firstName, lastName, secondName, curp, birthday, login, confirmPassword);
			c.cerrarConexion();
		}
		else {
			System.out.println("Las contraseñas no coinciden. Intente de nuevo");
		}
		
		doGet(request, response);
	}

}
