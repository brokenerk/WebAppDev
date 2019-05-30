package wad.cart.ramos.diaz.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import wad.cart.ramos.diaz.bs.PruebaBs;
import wad.cart.ramos.diaz.entidad.User;

/**
 * Servlet implementation class EjemploUsers
 */
public class EjemploUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PruebaBs pruebaBs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjemploUsers() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		List<User> users = pruebaBs.findAllUsers();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Users</h2>");
		out.println("<table>");
		out.println("	<thead>");
		out.println("<tr>");
		out.println("<th>First name</th>");
		out.println("<th>Last name</th>");
		out.println("<th>Second last name</th>");
		out.println("<th>Login</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for (User user : users) {
			out.println("<tr>");
			out.println("<td>" + user.getName() + "</td>");
			out.println("<td>" + user.getLastName() + "</td>");
			out.println("<td>" + user.getSecondLastName() + "</td>");
			out.println("<td>" + user.getLogin() + "</td>");
			out.println("<td><a href=\"ViewUser?idUser=" + user.getId() + "\">View</a>");
			out.println("<td><a href=\"EjemploOrders?idUser=" + user.getId() + "\">Cart</a>");
			out.println("<td><a href=\"EjemploCreditCard?idUser=" + user.getId() + "\">CreditCards</a>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
