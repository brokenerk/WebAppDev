package wad.hmwk7.ramos_diaz.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import wad.hmwk7.ramos_diaz.bs.UsersTableBs;
import wad.hmwk7.ramos_diaz.entidad.User;

public class UsersTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//Para usar la capa de negocio
	@Autowired
	private UsersTableBs usersTableBs;
	
    public UsersTable() {
        super();
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		//Configuramos la inyeccion de spring en el ServletContext
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//Negocio
		List<User> users = usersTableBs.findAllUsers();
		PrintWriter out = response.getWriter();
		
		//Construir tabla html
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Users Table</title>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Users</h2>");
		out.println("<table border='2'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>First name</th>");
		out.println("<th>Last name</th>");
		out.println("<th>Second last name</th>");
		out.println("<th>CURP</th>");
		out.println("<th>Birth day</th>");
		out.println("<th>Nickname</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		
		//Obtener datos del los usuarios
		for (User user : users) {
			out.println("<tr>");
			out.println("<td>" + user.getName() + "</td>");
			out.println("<td>" + user.getLastName() + "</td>");
			out.println("<td>" + user.getSecondLastName() + "</td>");
			out.println("<td>" + user.getCurp() + "</td>");
			out.println("<td>" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s").format(user.getBirthDay()) + "</td>");
			out.println("<td>" + user.getLogin() + "</td>");
			out.println("</tr>");
		}
		
		out.println("</tbody>");
		out.println("</table>");
		out.println("<br>");
        out.println("<a href='formUser.jsp'><button>New</button></a>");
        out.println("<a href='index.jsp'><button>Home</button></a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtenemos los parametros del formulario
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String secondName = request.getParameter("secondName");
		String curp = request.getParameter("curp");
		String birthday = request.getParameter("birthday");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		//Negocio
		usersTableBs.addUser(firstName, lastName, secondName, curp, birthday, login, password, confirmPassword);
		doGet(request, response);
	}

}
