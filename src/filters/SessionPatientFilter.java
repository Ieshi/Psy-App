package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/faces/patient/*"})
public class SessionPatientFilter implements Filter {
	
	private static final String ACCES_PUBLIC = "/";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
			HttpServletRequest request   = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) res;
			HttpSession session = request.getSession(false);
			
			System.out.println("Call Filter : SessionUserFilter, Current path : " + request.getRequestURL());
	        
			if ( session.getAttribute( "patient" ) == null )
	            response.sendRedirect( request.getContextPath() + ACCES_PUBLIC );
	        else
	            chain.doFilter( request, response );
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
