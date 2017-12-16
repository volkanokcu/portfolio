package com.portfolio.security.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.porfolio.domain.impl.User;
import com.porfolio.domain.impl.UserRole;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secret;

	public String generate(User user) {

		Claims claims = Jwts.claims().setSubject(user.getUsername());
		claims.put("id", String.valueOf(user.getId()));
		claims.put("roles", user.getUserRoles());

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	@SuppressWarnings("unchecked")
	public User validate(String token) {
		User user = null;
		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			user = new User();
			user.setUsername(body.getSubject());
			user.setId(Integer.parseInt((String) body.get("id")));
			List<LinkedHashMap<?, ?>> list = body.get("roles", ArrayList.class);
			Set<UserRole> roles = new HashSet<>();
			for (LinkedHashMap<?, ?> linkedHashMap : list) {
				UserRole userRole = new UserRole();
				userRole.setId((Integer) linkedHashMap.get("id"));
				userRole.setUserRole((String) linkedHashMap.get("userRole"));
				roles.add(userRole);
			}
			user.setUserRoles(roles);
		} catch (Exception e) {
			System.out.println(e);
		}

		return user;
	}

}
