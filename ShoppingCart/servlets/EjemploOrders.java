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
import wad.cart.ramos.diaz.entidad.OrderC;
import wad.cart.ramos.diaz.entidad.OrderDetail;
import wad.cart.ramos.diaz.entidad.Product;
import wad.cart.ramos.diaz.entidad.User;

/**
 * Servlet implementation class EjemploOrders
 */
public class EjemploOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PruebaBs pruebaBs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjemploOrders() {
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
		List<OrderC> orders = u.getOrders();
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Orders - Carrito</h2>");
		out.println("<ul>");
		
		for(OrderC order: orders) {
			out.println("<li> Orden Id: " + order.getId() + " Date: " + order.getDate() + " Total: $" + order.getTotal());
			out.println("<ul>");
			List<OrderDetail> orderDetails = order.getOrderDetails();
			
			for(OrderDetail orderDetail: orderDetails) {
				Product product = orderDetail.getProduct();
				out.println("<li> Producto: " + product.getName() + " Cantidad: " + orderDetail.getAmount());
			}
			
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
