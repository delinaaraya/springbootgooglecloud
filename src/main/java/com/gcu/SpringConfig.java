package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.*;

@Configuration
public class SpringConfig {
	
	@Bean(name="productBusinessService", initMethod="init", destroyMethod="destroy")
	//@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	//@SessionScope
	public ProductBusinessService getProductsBusiness() {
		return new ProductBusinessService();
	}
}
