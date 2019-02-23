package wad.p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Punto4
 */
public class Punto4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int counter = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Punto4() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ((request.getMethod()).equals("GET")) {
			counter++;
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h2>Number of GET Requests: " + counter + "</h2>");
			out.println("<br>");
			out.println("<a href='index.jsp'><button>Home</button></a>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
	}
}
