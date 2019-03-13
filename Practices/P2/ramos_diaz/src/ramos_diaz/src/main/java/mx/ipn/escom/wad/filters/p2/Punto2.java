package mx.ipn.escom.wad.filters.p2;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Punto2
 */
public class Punto2 implements Filter {

    public Punto2() {
    }
    
    public boolean esRecurso(String url) {
    	String[] recursos = {"carnage.jpg", "snake.html", "UsersTable"};
    	 for(String r : recursos){
             if(url.endsWith(r)){
                 return true;
             }
         }
         return false;	
    }

	public void destroy() {
	}
	//Filtro: /ramos_diaz/resources/*
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

		String IP = req.getRemoteAddr();
		DateFormat datef = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat timef = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String metodo = req.getMethod();
		String recurso = req.getRequestURI();
		
		System.out.print("LOG: " + IP + " | " + datef.format(date.getTime()) + " | " + timef.format(date.getTime()) + " | " + metodo + " | " + recurso + " | ");

		if(esRecurso(recurso)) {
	    	if(session == null || session.getAttribute("currentSessionCuenta") == null || session.getAttribute("currentSessionPersona") == null) {
	    		System.out.println("NOT ALLOWED");
	    		res.sendError(403,"Acceso denegado.");
	    	}
	    	else {
	    		System.out.println("ALLOWED");
	    		chain.doFilter(request, response);
	    	}	
		}
		else {
			System.out.println("ALLOWED");
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
