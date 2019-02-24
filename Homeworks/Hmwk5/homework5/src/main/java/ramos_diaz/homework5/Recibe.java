package ramos_diaz.homework5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Recibe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Recibe() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        /*Leemos, enumeramos y ordenamos los nombres de los nombres de los 
         parametros desde el request*/
        Enumeration<String> enumParams = request.getParameterNames();
        List<String> listaParams = Collections.list(enumParams);
        Collections.sort(listaParams);
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Receive dynamic parameters </title>");
        out.println("<head>");
		out.println("<body>");
		out.println("<h1>Sending dynamic parameters</h1>");
		out.println("<ol>");
		
		/*Organizamos la forma de mostrar los parametros con su valor*/
		for (String nombre: listaParams) {
			/*Obtenemos el o los valores de cada parametro, segun su nombre*/
			String values[] = request.getParameterValues(nombre);
			
			/*Si un parametro tiene solo 1 valor, lo imprimos directamente*/
			if(values.length == 1) {
				out.println("<li>" + nombre + ": " + values[0]);
			}
			else {
				/*Si un parametro tiene muchos valores, los listamos*/
				out.println("<li>" + nombre + ": ");
				out.println("<ul>");
				
				for(int i = 0; i < values.length; i++) {
					out.println("<li>" + values[i]);
				}
				
				out.println("</ul>");
			} 
		}
		out.println("</ol>");
		out.println("<a href='index.jsp'><button>Return</button></a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
