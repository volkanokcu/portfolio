package com.portfolio.security.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.porfolio.domain.impl.User;
import com.portfolio.security.common.JwtUtil;

@Component
public class LoginAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    
	private final ObjectMapper mapper;
	private final JwtUtil jwtUtil;
    
    @Autowired
    public LoginAwareAuthenticationSuccessHandler(ObjectMapper mapper, JwtUtil jwtUtil) {
        this.mapper = mapper;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        
    	User user = (User) authentication.getPrincipal();
        String jwtToken = jwtUtil.generate(user);
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
       	//Userin passwordunu göndermek istemiyoruz
        user.setPassword(null);
        mapper.writeValue(response.getWriter(), new LoginResponse(jwtToken, user, HttpStatus.OK.toString()));

        clearAuthenticationAttributes(request);
    }

    /**
     * Removes temporary authentication-related data which may have been stored
     * in the session during the authentication process..
     * 
     */
    protected final void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return;
        }

        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
