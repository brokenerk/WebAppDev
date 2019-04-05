package wad.hmwk7.ramos_diaz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import wad.hmwk7.ramos_diaz.bs.LoginBs;
import wad.hmwk7.ramos_diaz.entidad.Account;
import wad.hmwk7.ramos_diaz.entidad.User;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//Para usar la capa de negocio
	@Autowired
	private LoginBs loginBs;
	
    public Login() {
        super();
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		//Configuramos la inyeccion de spring en el ServletContext
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//Obtenemos los parametros del html
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//Negocio
		User user = loginBs.logIn(username, password);
		
		if(user != null) {
			//El usuario se auntentifico correctamente, mostrar pagina de bienvenida
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Welcome!!!!</title>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Bienvenido</h1><br>");
			//Obtenemos nombre completo
			out.println(user.getFullName() + "<br><br>");
			
			//Revisamos sus cuentas asociadas para obtener sus roles disponibles
			for(Account a: user.getAccounts()) {
				out.println(a.getRole().getName() + ": "+ a.getRole().getDescription() + "<br>");
			}
			
			out.println("<br><a href='index.jsp'><button>Home</button></a>");
			out.println("</body>");
			out.println("</html>");
		}
		else {
			//Datos ingresados no validos, ya sea username o contraseña
			System.out.println("usuario no valido");
			//Redirigimos a la vista de login incorrecto
			RequestDispatcher rd2 = request.getRequestDispatcher("wrongLogin.jsp");
			rd2.forward(request, response);
		}
	}
}
