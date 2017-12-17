package com.portfolio.security.jwt;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	public static final String AUTHENTICATION_HEADER_NAME = "Authorization";
	public static final String HEADER_PREFIX = "Bearer ";
	
	public JwtAuthenticationFilter(String defaultFilterProcessesUrl) {
		super(defaultFilterProcessesUrl);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

        String header = request.getHeader(AUTHENTICATION_HEADER_NAME);
      
        if (header == null || !header.startsWith(HEADER_PREFIX)) {
            throw new RuntimeException("JWT Token is missing");
        }
        
        String token = header.substring(6);
       
        JwtAuthenticationToken authenticationToken = new JwtAuthenticationToken(token);
        Authentication authentication = super.getAuthenticationManager().authenticate(authenticationToken);
        return authentication;
      
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		//Burayı çözemedim.
		SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authResult);
        SecurityContextHolder.setContext(context);
        chain.doFilter(request, response);
        
	}

}
