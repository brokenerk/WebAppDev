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
import wad.cart.ramos.diaz.entidad.Product;

/**
 * Servlet implementation class EjemploProducts
 */
public class EjemploProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	private PruebaBs pruebaBs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjemploProducts() {
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
		List<Product> products = pruebaBs.findAllProducts();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Products</h2>");
		out.println("<table>");
		out.println("	<thead>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<th>Description</th>");
		out.println("<th>Stock</th>");
		out.println("<th>Price</th>");
		out.println("<th>Discount</th>");
		out.println("<th>Image</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for (Product product : products) {
			out.println("<tr>");
			out.println("<td>" + product.getName() + "</td>");
			out.println("<td>" + product.getDescription() + "</td>");
			out.println("<td>" + product.getStock() + "</td>");
			out.println("<td>" + product.getPrice() + "</td>");
			out.println("<td>" + product.getDiscount() + "</td>");
			out.println("<td>" + product.getImage() + "</td>");
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
