package mx.ipn.escom.wad.servlets.p2;

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


public class Punto1 implements Filter {


    public Punto1() {
        
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String IP = request.getRemoteAddr();
		DateFormat datef = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat timef = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		
		System.out.println("IP: " + IP);
		System.out.println("Date: " + datef.format(date.getTime()));
		System.out.println("Time: " + timef.format(date.getTime()));
		
		
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
