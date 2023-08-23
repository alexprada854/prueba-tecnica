package com.acme.newjob.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.acme.newjob.util.AppConstants;


@Configuration
public class TokenConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.acme.mock.wsdl");
		return marshaller;
	}

	@Bean
	public TokenClient tokenClient(Jaxb2Marshaller marshaller) {
		TokenClient client = new TokenClient();
		client.setDefaultUri(AppConstants.WS_URL);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}