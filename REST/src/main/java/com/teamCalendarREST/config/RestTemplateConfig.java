package com.teamCalendarREST.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RestTemplateConfig {

	@Bean
	@RequestScope
	public RestTemplate restTemplate(HttpServletRequest request) {

		final RestTemplate restTemplate = new RestTemplate();

		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(new ObjectMapper());
		restTemplate.getMessageConverters().add(converter);
		return restTemplate;
	}

}