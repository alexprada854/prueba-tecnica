package com.acme.newjob.config;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.acme.mock.wsdl.GetTokenRequest;
import com.acme.mock.wsdl.GetTokenResponse;
import com.acme.mock.wsdl.Login;
import com.acme.newjob.dto.LoginRequest;
import com.acme.newjob.util.AppConstants;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;

/**
 * Clase para hacer el llamado del WS
 * @author Alex
 *
 */
public class TokenClient extends WebServiceGatewaySupport {
	//private static final Logger log = LoggerFactory.getLogger(CountryClient.class);
	/*private final CircuitBreaker circuitBreaker;
	private final Retry retry;
	private final WebServiceTemplate webServiceTemplate;
	public TokenClient() {
		this.circuitBreaker = null;
		this.retry = null;
		this.webServiceTemplate = null;
	}
	
	@Autowired
	public TokenClient(CircuitBreakerRegistry circuitBreakerRegistry, RetryRegistry retryRegistry,WebServiceTemplate webServiceTemplate) {
		this.circuitBreaker = circuitBreakerRegistry.circuitBreaker("tokenClientCircuitBreaker");
		this.retry = retryRegistry.retry("tokenClientRetry");
		this.webServiceTemplate = webServiceTemplate;
	}*/
	
	/**
     * implementacion para el llamado al token con manejo de Resiliencia
     * @param request
     * @return
     */
	public GetTokenResponse getToken(String userName) {
		GetTokenRequest request = new GetTokenRequest();
		Login login = new Login();
		login.setUserName(userName);
		request.setLogin(login);
		AppConstants.log.info("Requesting for " + userName);
		GetTokenResponse response = (GetTokenResponse) getWebServiceTemplate().marshalSendAndReceive(
				AppConstants.WS_URL + "/login", request,
				new SoapActionCallback("http://com.acme.job/login-web-service/GetTokenRequest"));
		AppConstants.log.info("Response = " + response.toString());
		return response;
	}
	/*
	public GetTokenResponse getToken(String userName) {
		Supplier<GetTokenResponse> supplier = () -> {
            GetTokenRequest request = new GetTokenRequest();
            Login login = new Login();
            login.setUserName(userName);
            request.setLogin(login);

            AppConstants.log.info("Requesting for " + userName);
            return (GetTokenResponse) webServiceTemplate.marshalSendAndReceive(
                    AppConstants.WS_URL + "/login", request,
                    new SoapActionCallback("http://com.acme.job/login-web-service/GetTokenRequest"));
        };

        Supplier<GetTokenResponse> retrySupplier = Retry.decorateSupplier(retry, supplier);

        return circuitBreaker.executeSupplier(retrySupplier);
	}*/

}