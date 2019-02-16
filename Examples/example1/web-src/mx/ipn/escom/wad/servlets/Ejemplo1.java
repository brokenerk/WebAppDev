package mx.ipn.escom.wad.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.io.IOException;

public class Ejemplo1 extends HttpServlet{ 
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Example 1</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello world!!!</h1>");
		out.println("</body>");
		out.println("</html>");
        }
}
