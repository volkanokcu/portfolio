package com.portfolio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.portfolio.constants.Constants;
import com.portfolio.domain.impl.About;
import com.portfolio.domain.impl.AboutTranslation;
import com.portfolio.domain.impl.Language;
import com.portfolio.domain.impl.User;
import com.portfolio.domain.impl.UserRole;
import com.portfolio.service.AboutService;
import com.portfolio.service.LanguageService;
import com.portfolio.service.UserRoleService;
import com.portfolio.service.UserService;

@Component
public class AppStartup implements ApplicationListener<ApplicationReadyEvent>{
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String hibernateDllAuto;
	
	@Value("${default.user.username}")
	private String username;
	
	@Value("${default.user.password}")
	private String password;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AboutService aboutService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private LanguageService languageService;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		if ("create".equals(hibernateDllAuto)) {
			//Create default userRole
			UserRole userRole = new UserRole();
			userRole.setId(1);
			userRole.setName("ROLE_" + Constants.ROLE_ADMIN);
			userRoleService.save(userRole);
			
			//Create default admin
			User user = new User();
			user.setUsername(username);
			user.setPassword(encoder.encode(password));
			Set<UserRole> userRoles = new HashSet<>();
			userRoles.add(userRole);
			user.setUserRoles(userRoles);
			userService.save(user);
			
			//Create default language
			Language language = new Language();
			language.setId(1);
			language.setName("tr");
			languageService.save(language);
			
			//Create default about
			About about = new About();
			about.setFirstName("İsminiz");
			about.setLastName("Soyisminiz");
			AboutTranslation aboutTranslation = new AboutTranslation();
			aboutTranslation.setLanguage(language);
			aboutTranslation.setDescription("Hakkınızda Bilgileri Buraya Yazınız");
			List<AboutTranslation> translations = new ArrayList<>();
			translations.add(aboutTranslation);
			about.setTranslations(translations);
			aboutService.save(about);
		}
	}

}
