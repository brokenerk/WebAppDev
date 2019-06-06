package wad.cart.ramos.diaz.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import wad.cart.ramos.diaz.bs.LoginBs;

@Results({ @Result(name = "login-cart", type = "redirectAction", params = { "actionName", "login/cart"}),
		   @Result(name = "login-buy", type = "redirectAction", params = { "actionName", "login/cart"}),
		   @Result(name = "login-credit-card", type = "redirectAction", params = { "actionName", "login/credit-card"}),
		   @Result(name = "login-orders", type = "redirectAction", params = { "actionName", "login/orders" }),
		   @Result(name = "login-products", type = "redirectAction", params = { "actionName", "login/products" }),
		   @Result(name = "login-users", type = "redirectAction", params = { "actionName", "login/users"})})
public class LoginInterceptor extends AbstractInterceptor implements StrutsStatics {
	@Autowired
	private LoginBs loginBs;
	
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	public void destroy() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(false);
		Integer idUser = (Integer) session.getAttribute("idUser");
		String url = request.getRequestURI();

		if (idUser == null || session == null) {
			String ret = "login-" + loginBs.findView(url);
			return ret;
		} 
		else
			return invocation.invoke();
	}
}
