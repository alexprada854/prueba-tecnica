package com.acme.newjob.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.mock.wsdl.GetTokenResponse;
import com.acme.newjob.config.TokenClient;
import com.acme.newjob.dto.LoginRequest;
import com.acme.newjob.model.TokenUser;
import com.acme.newjob.repository.TokenUserRepository;
import com.acme.newjob.util.AppConstants;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/api/Main")
public class MainController {

	private final TokenClient tokenClient;
	private final TokenUserRepository repository;
	@Autowired
	public MainController(TokenClient tokenClient,TokenUserRepository repository) {
		this.tokenClient = tokenClient;
		this.repository = repository;
	}
	/**
	 * LLamado desde el exterior para la solicitud del token
	 * @param request
	 * @return
	 */
	@PostMapping("/login")
    @Retry(name = "loginRetry", fallbackMethod = "handleLoginRetry")
    @CircuitBreaker(name = "loginCircuitBreaker", fallbackMethod = "handleLoginCircuitBreaker")
	public String login(@RequestBody LoginRequest request) {
		System.out.println("haciendo llamado 3="+AppConstants.WS_URL+" con "+request.toString());
        GetTokenResponse response = tokenClient.getToken(request.getUsername());
        System.err.println(response.getToken());
        System.out.println("Guardando en H2");
        repository.save(new TokenUser(request.getUsername(), response.getToken()));
        System.out.println("Listando elementos");
        for (TokenUser usuario : repository.findAll()) {
			AppConstants.log.info(usuario.toString());
		}
		return response.getToken();
	}
	
	public String handleLoginCircuitBreaker(Exception e) {
		System.out.println("Se cerro el llamado a"+AppConstants.WS_URL);
		return "Error al obtener el Token, implemetar accion";
	}

	public String handleLoginRetry(Exception e) {
		System.out.println("Se esta reintentando"+AppConstants.WS_URL);
		return "implementar accion de reintento";
	}

}
