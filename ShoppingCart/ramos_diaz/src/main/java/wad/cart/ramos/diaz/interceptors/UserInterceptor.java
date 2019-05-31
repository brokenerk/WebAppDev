package wad.cart.ramos.diaz.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class UserInterceptor extends AbstractInterceptor implements StrutsStatics {
	private static final long serialVersionUID = 1L;

	public void init() {
		System.out.println("----------> Init()");
	}

	public void destroy() {
		System.out.println("----------> Destroy()");
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		final ActionContext context = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
		HttpSession session = request.getSession(false);
		Integer idUser = (Integer) session.getAttribute("idUser");
		
		if (idUser == null) {
			System.out.println("----------> Login");
			return "login";
		} 
		else {
			System.out.println("----------> Invoke()");
			return invocation.invoke();
		}
	}

}
