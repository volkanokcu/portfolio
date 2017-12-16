package com.portfolio.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.porfolio.domain.impl.User;
import com.portfolio.security.common.JwtUtil;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	JwtUtil JwtUtil;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String token = ((JwtAuthenticationToken)authentication).getToken();
		User user = JwtUtil.validate(token);
		return new JwtAuthenticationToken(user.getAuthorities());
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
