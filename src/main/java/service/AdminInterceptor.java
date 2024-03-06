package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import auth.Auth;

public class AdminInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("AdminInterceptor  preHandle ");
		HttpSession session = request.getSession();
		Auth auth = (Auth) session.getAttribute("auth");
		
		if (auth==null || !auth.getId().equals("m1")) {
			response.sendRedirect(request.getContextPath()
					+"/auth/login?url="+request.getRequestURI());
			System.out.println(request.getRequestURI());
			return false;
			}
		return true;		
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("AdminInterceptor  afterCompletion ");
	}
	
	
}
