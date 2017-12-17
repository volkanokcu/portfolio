package com.portfolio.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.portfolio.CustomCorsFilter;
import com.portfolio.constants.Constants;
import com.portfolio.security.RestAuthenticationEntryPoint;
import com.portfolio.security.jwt.JwtAuthenticationFilter;
import com.portfolio.security.jwt.JwtAuthenticationProvider;
import com.portfolio.security.login.LoginAuthenticationProvider;
import com.portfolio.security.login.LoginAuthenticationFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	public final static String AUTHENTITATION_LOGIN_URL = "/login";
	public final static String AUTHORIZED = "/admin/**";
	
    @Autowired private RestAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired private AuthenticationSuccessHandler successHandler;
    @Autowired private AuthenticationFailureHandler failureHandler;
    @Autowired private LoginAuthenticationProvider loginAuthenticationProvider;
    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private JwtAuthenticationProvider jwtAuthenticationProvider;
    
	protected LoginAuthenticationFilter buildLoginAuthenticationFilter(String defaultFilterProcessesUrl) {
		
		LoginAuthenticationFilter filter = new LoginAuthenticationFilter(defaultFilterProcessesUrl, successHandler, failureHandler);
		filter.setAuthenticationManager(this.authenticationManager);
        return filter;
        
	}
	
	protected JwtAuthenticationFilter buildJwtAuthenticationFilter(String defaultFilterProcessesUrl) {
		
		JwtAuthenticationFilter filter = new JwtAuthenticationFilter(defaultFilterProcessesUrl);
		filter.setAuthenticationManager(this.authenticationManager);
		return filter;
		
	}
	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(loginAuthenticationProvider);
        auth.authenticationProvider(jwtAuthenticationProvider);
    }
	 
    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	 http
         .csrf().disable()
         // CSRF'yi kapat.
         .exceptionHandling()
         .authenticationEntryPoint(this.authenticationEntryPoint)

         
         //Sesion tutma. Zaten her requestte Jwt token kontrolu yapılacak. Sesion tutmaya gerek yok.
         .and()
             .sessionManagement()
             .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

         //Bu eşleşmeleri role göre filtrele.
         .and()
         	.authorizeRequests()
         	.antMatchers(AUTHORIZED)
         	.hasRole(Constants.ROLE_ADMIN)
         
         .and()
         	//Allow cors
         	.addFilterBefore(new CustomCorsFilter(), UsernamePasswordAuthenticationFilter.class)
         	//Filter login url
         	.addFilterBefore(buildLoginAuthenticationFilter(AUTHENTITATION_LOGIN_URL), UsernamePasswordAuthenticationFilter.class)
         	//Filter admin urls
         	.addFilterBefore(buildJwtAuthenticationFilter(AUTHORIZED), UsernamePasswordAuthenticationFilter.class);

    }
}
