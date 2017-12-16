package com.portfolio.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.portfolio.domain.impl.About;
import com.portfolio.domain.impl.AboutTranslation;
import com.portfolio.domain.impl.Language;
import com.portfolio.dto.AboutDTO;

@Component
public class AboutDTOMapper {

	public AboutDTO toDTO(About about, Language language) {
		AboutDTO aboutDTO = new AboutDTO();
		aboutDTO.setId(about.getId());
		aboutDTO.setFirstName(about.getFirstName());
		aboutDTO.setLastName(about.getLastName());
		List<AboutTranslation> translations = about.getTranslations().stream().filter(s -> s.getLanguage().equals(language)).collect(Collectors.toList());
		aboutDTO.setDescription(translations.get(0).getDescription());
		return aboutDTO;
	}
	
}
