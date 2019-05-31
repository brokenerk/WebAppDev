package wad.cart.ramos.diaz.interceptors;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import wad.cart.ramos.diaz.bs.LoginBs;

@Results({ @Result(name = "login-cart", type = "redirectAction", params = { "actionName", "login/1"}),
		   @Result(name = "login-credit-card", type = "redirectAction", params = { "actionName", "login/2"}),
		   @Result(name = "login-orders", type = "redirectAction", params = { "actionName", "login/3" }),
		   @Result(name = "login-products", type = "redirectAction", params = { "actionName", "login/4"}),
		   @Result(name = "login-users", type = "redirectAction", params = { "actionName", "login/5"})})
public class LoginInterceptor extends AbstractInterceptor implements StrutsStatics {
	@Autowired
	private LoginBs loginBs;
	private HashMap<Integer, String> views = new HashMap<>();
	
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	public void destroy() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		views = loginBs.fillViews(views);
		String[] values = loginBs.getValues(views);
		Integer[] keys = loginBs.getKeys(views);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(false);
		Integer idUser = (Integer) session.getAttribute("idUser");
		String url = request.getRequestURI();

		if (idUser == null || session == null) {
			Integer idView = 0;
			
			for(int i = 0; i < values.length; i++) {
				if(url.endsWith(values[i])) {
					idView = keys[i];
				}
			}
			String retorno = "login-products";
			switch(idView) {
				case 1:
					retorno = "login-cart";
					break;
				case 2:
					retorno = "login-credit-card";
					break;
				case 3:
					retorno = "login-orders";
					break;
				case 4:
					retorno = "login-products";
					break;
				case 5:
					retorno = "login-users";
					break;
			}
			return retorno;
		} 
		else {
			return invocation.invoke();
		}
	}

}
