package com.acme.mock.config;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import job.acme.com.login_web_service.GetTokenRequest;
import job.acme.com.login_web_service.GetTokenResponse;


@Endpoint
public class LoginEndpoint {
	private static final String NAMESPACE_URI = "http://com.acme.job/login-web-service";

	/*
	private CountryRepository countryRepository;

	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}*/

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTokenRequest")
	@ResponsePayload
	public GetTokenResponse getToken(@RequestPayload GetTokenRequest request) {
		GetTokenResponse response = new GetTokenResponse();
		response.setToken("{\"alg\": \"HS256\",\"typ\": \"JWT\",\"user\":\""+ request.getLogin().getUserName()+"\"}");
		
		return response;
	}
}
