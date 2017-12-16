package com.portfolio.security.login;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


public class LoginAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	
	private final AuthenticationSuccessHandler successHandler;
	private final AuthenticationFailureHandler failureHandler;
	
	public LoginAuthenticationFilter(String defaultFilterProcessesUrl, AuthenticationSuccessHandler successHandler, 
			AuthenticationFailureHandler failureHandler) {
		
		super(defaultFilterProcessesUrl);
		this.successHandler = successHandler;
		this.failureHandler = failureHandler;
		
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		//Requst içinden gelen parametreleri alıyoruz. 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//Username ve Password boş ise exception fırlat.
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new AuthenticationServiceException("Username or Password not provided");
        }
        
        //Bu nesnemizin constructorı bizden principal(username) ve credentials(password) 2 value istiyor.
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        
        //Geriye Authentication(Doğrulama) nesnesi döndürmemiz gerekiyor.
        //Superden authenticationManager nesnesini çağırıp tokenımızı authenticate(doğrula) methodununa gönderdiyoruz...
        //... bu methoduda LoginAuthenticationProvider sınıfımızda override ettik.
        //Bize bir Authentication(Doğrulama nesnesi dönüyor) bizde override ettiğimiz methodla döndürüyoruz.
        Authentication authentication = super.getAuthenticationManager().authenticate(token);
		
        return authentication;
        
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		successHandler.onAuthenticationSuccess(request, response, authResult);
		
	}
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		
		failureHandler.onAuthenticationFailure(request, response, failed);
		
	}

}
