package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.*;

@Configuration
public class SpringConfig {
	
	@Bean(name="productBusinessService", initMethod="init", destroyMethod="destroy")
	@SessionScope
	public ProductBusinessServiceInterface getProductsBusiness() {
		return new ProductBusinessService();
	}
}
