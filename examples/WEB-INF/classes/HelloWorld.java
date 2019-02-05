//TOMCAT FOLDER: /var/lib/tomcat8/webapps/
//Compile: sudo javac -cp .:../lib/javax.servlet-api-3.0.1.jar: HelloWorld.java
//START TOMCAT: sudo service tomcat8 start

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
