package wad.cart.ramos.diaz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import wad.cart.ramos.diaz.bs.PruebaBs;
import wad.cart.ramos.diaz.entidad.Address;
import wad.cart.ramos.diaz.entidad.User;

/**
 * Servlet implementation class ViewUser
 */
public class ViewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	private PruebaBs pruebaBs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUser() {
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
		
		Integer idUser = Integer.parseInt(request.getParameter("idUser"));
		User u = pruebaBs.findById(idUser);
		Address a = u.getAddress();
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Id User: " + u.getId() + "</h2>");
		out.println("<ul>");
		out.println("<li>Name: " + u.getName());
		out.println("<li>LastName: " + u.getLastName());
		out.println("<li>Second last name: " + u.getSecondLastName());
		out.println("<li>Login: " + u.getLogin());
		out.println("<li>Street: " + a.getStreet());
		out.println("<li>City: " + a.getCity());
		out.println("<li>State: " + a.getState());
		out.println("<li>ZIPCODE: " + a.getZipCode());
		out.println("<li>Tel: " + a.getTelephone());
		
		out.println("</ul>");
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
