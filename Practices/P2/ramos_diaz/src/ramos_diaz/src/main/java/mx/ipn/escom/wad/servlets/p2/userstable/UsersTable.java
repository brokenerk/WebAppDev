package mx.ipn.escom.wad.servlets.p2.userstable;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Conexion c;
       
    public UsersTable() {
        super();
        c = new Conexion("org.postgresql.Driver", "jdbc:postgresql://localhost/", "homework-6", "postgres", "postgres");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
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

}
