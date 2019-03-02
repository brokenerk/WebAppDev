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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class Punto1 implements Filter {

    public Punto1() {
    }
    //Filtro: /*
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String IP = req.getRemoteAddr();
		DateFormat datef = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat timef = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String metodo = req.getMethod();
		String recurso = req.getRequestURI();
		
		System.out.println("LOG: " + IP + " | " + datef.format(date.getTime()) + " | " + timef.format(date.getTime()) + " | " + metodo + " | " + recurso);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}
}
