package vn.hcmute;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;


public class ClickjackingFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("X-Frame-Options", "DENY");
        filterChain.doFilter(servletRequest, servletResponse);
    }
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
//            throws IOException, ServletException {
//        HttpServletResponse response = (HttpServletResponse) servletResponse;    
//		//  response.setHeader("Content-Security-Policy", "frame-ancestors 'none'");
//        response.setHeader("Content-Security-Policy", "frame-ancestors 'none'; script-src 'self'; style-src 'self'"); 
// 		//	Chuyển tiếp request đến filter tiếp theo trong chuỗi
//        filterChain.doFilter(servletRequest, servletResponse);}


}