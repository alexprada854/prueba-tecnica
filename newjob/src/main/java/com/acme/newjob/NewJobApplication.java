package com.acme.newjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

//import com.acme.job.controller.TokenUserController;
import com.acme.mock.wsdl.GetTokenResponse;
import com.acme.newjob.config.TokenClient;
import com.acme.newjob.dto.LoginRequest;
import com.acme.newjob.util.AppConstants;

/**
 * Iniciacion del servicio SpringBoot
 * @author Alex
 *
 */
@SpringBootApplication
public class NewJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewJobApplication.class, args);
		System.out.println("Hola");
	}
	
    @Bean
    CommandLineRunner lookup(TokenClient quoteClient) {
      return args -> {
        String country = "AlexP";

        if (args.length > 0) {
          country = args[0];
        }
		System.out.println("haciendo llamado 2="+AppConstants.WS_URL);
        GetTokenResponse response = (GetTokenResponse) quoteClient.getToken(country);
        System.err.println(response.getToken());
      };
    }
}
