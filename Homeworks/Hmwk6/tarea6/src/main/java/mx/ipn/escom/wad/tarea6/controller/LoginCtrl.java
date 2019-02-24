package mx.ipn.escom.wad.tarea6.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.ipn.escom.wad.tarea6.bs.LoginBs;
import mx.ipn.escom.wad.tarea6.entidad.Cuenta;
import mx.ipn.escom.wad.tarea6.entidad.Persona;
import mx.ipn.escom.wad.tarea6.entidad.Usuario;
import mx.ipn.escom.wad.tarea6.exception.UserBlockedException;
import mx.ipn.escom.wad.tarea6.exception.UserNotFoundException;

/**
 * Servlet implementation class LoginCtrl
 */
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCtrl() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario;
		Persona u_persona;
		Cuenta cuenta;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			//Logica de negocios para tratar la respuesta de 
			cuenta = LoginBs.login(username, password);
			usuario = cuenta.getUsuario();
			u_persona = usuario.getPersona();

			HttpSession session = request.getSession();
			//session.setAttribute("currentSessionUser", usuario);
			session.setAttribute("currentSessionPersona", u_persona);
			session.setAttribute("currentSessionCuenta", cuenta);
			
			//Inicio de sesion exitoso
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		} catch (UserNotFoundException e) {
			//Datos ingresados no validos
			System.out.println("usuario no valido");
			RequestDispatcher rd2 = request.getRequestDispatcher("wrongLogin.jsp");
			rd2.forward(request, response);
			e.printStackTrace();
		} catch (UserBlockedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
