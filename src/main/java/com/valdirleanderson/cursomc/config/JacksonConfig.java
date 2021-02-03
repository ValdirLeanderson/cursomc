package com.valdirleanderson.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.valdirleanderson.cursomc.domain.PagamentoBoleto;
import com.valdirleanderson.cursomc.domain.PagamentoCartao;

//https://stackoverflow.com/questions/41452598/overcome-can-not-construct-instance-of- interfaceclass-without-hinting-the-pare
@Configuration
public class JacksonConfig {
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() { 
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(PagamentoCartao.class);
				objectMapper.registerSubtypes(PagamentoBoleto.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}
}
