package mx.ipn.escom.wad.servlets.p2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.ipn.escom.wad.servlets.p2.bs.LoginBs;
import mx.ipn.escom.wad.servlets.p2.entidad.Cuenta;
import mx.ipn.escom.wad.servlets.p2.entidad.Persona;
import mx.ipn.escom.wad.servlets.p2.entidad.Usuario;
import mx.ipn.escom.wad.servlets.p2.exception.UserBlockedException;
import mx.ipn.escom.wad.servlets.p2.exception.UserNotFoundException;

public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario;
		Persona u_persona;
		Cuenta cuenta;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			//Logica de negocios para tratar la respuesta de 
			cuenta = LoginBs.login(username, password);
			
			if(cuenta != null) {
				usuario = cuenta.getUsuario();
				u_persona = usuario.getPersona();
				//Subimos el usuario a la sesión
				HttpSession session = request.getSession();
				//session.invalidate();
				session.setAttribute("currentSessionPersona", u_persona);
				session.setAttribute("currentSessionCuenta", cuenta);
				//System.out.println("Sesión del usuario creada.");
				//Inicio de sesion exitoso
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}
			
		} catch (UserNotFoundException e) {
			//Datos ingresados no validos
			RequestDispatcher rd2 = request.getRequestDispatcher("wrongLogin.jsp");
			rd2.forward(request, response);
			e.printStackTrace();
		} catch (UserBlockedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
