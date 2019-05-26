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
import wad.cart.ramos.diaz.entidad.CardUser;
import wad.cart.ramos.diaz.entidad.CreditCard;
import wad.cart.ramos.diaz.entidad.User;

/**
 * Servlet implementation class EjemploCreditCard
 */
public class EjemploCreditCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PruebaBs pruebaBs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjemploCreditCard() {
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
		List<CardUser> cardsUser = u.getCreditCards();
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Credit Cards</h2>");
		out.println("<ul>");
		
		
		for(CardUser cu: cardsUser) {
			CreditCard creditCard = cu.getCreditCard();
			
			out.println("<li> Id: " + creditCard.getId());
			out.println("<ul>");
			out.println("<li> Num: " + creditCard.getNumber());
			out.println("<li> Owner: " + creditCard.getOwner());
			out.println("<li> Expiration: " + creditCard.getExpiration());
			out.println("<li> Street: " + creditCard.getStreet());
			out.println("<li> City: " + creditCard.getCity());
			out.println("<li> State: " + creditCard.getState());
			out.println("<li> ZIPCODE: " + creditCard.getZipCode());
			out.println("</ul>");
			out.println("<br>");
			
		}
		
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
