package mx.ipn.escom.wad.listeners.p2;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Punto4 implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener, ServletRequestListener, ServletRequestAttributeListener {

    public Punto4() {
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("LOG: Sesion creada: " + se.getSession().getId());
    }

    public void attributeRemoved(ServletContextAttributeEvent event)  { 
    	System.out.println("LOG: Atributo contexto eliminado: " + event.getName() + " -> " + event.getValue());
    }

    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
       	System.out.println("LOG: Atributo request agregado: " + srae.getName() + " -> " + srae.getValue()); 
    }

    public void attributeReplaced(HttpSessionBindingEvent event)  { 
       	System.out.println("LOG: Atributo sesion reemplazado: " + event.getName() + " -> " + event.getValue());  
    }

    public void contextInitialized(ServletContextEvent sce)  { 
       	System.out.println("LOG: Contexto inicializado: " + sce.getServletContext().getServletContextName());   
    }

    public void attributeAdded(ServletContextAttributeEvent event)  { 
     	System.out.println("LOG: Atributo contexto agregado: " + event.getName() + " -> " + event.getValue());  
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
     	System.out.println("LOG: Request destruido: " + sre.getServletRequest()); 
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	System.out.println("LOG: Atributo request eliminado: " + srae.getName() + " -> " + srae.getValue());
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
     	System.out.println("LOG: Request inicializado: " + sre.getServletRequest());  
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("LOG: Sesion destruida: " + se.getSession().getId() + " | " + se.getClass().getName());
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
      	System.out.println("LOG: Contexto destruido: " + sce.getServletContext().getServletContextName());    
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	System.out.println("LOG: Atributo request reemplazado: " + srae.getName() + " -> " + srae.getValue());	
    }

    public void attributeAdded(HttpSessionBindingEvent event)  { 
       	System.out.println("LOG: Atributo sesion agregado: " + event.getName() + " -> " + event.getSession().getId());  
    }

    public void attributeRemoved(HttpSessionBindingEvent event)  { 
       	System.out.println("LOG: Atributo sesion eliminado: " + event.getName() + " -> " + event.getSession().getId());
    }

    public void attributeReplaced(ServletContextAttributeEvent event)  { 
       	System.out.println("LOG: Atributo contexto reemplazado: " + event.getName() + " -> " + event.getValue());   
    }	
}
