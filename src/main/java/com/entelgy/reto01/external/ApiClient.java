package com.entelgy.reto01.external;

import com.entelgy.reto01.external.model.UserApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class ApiClient {
    private String apiExternalUrl;

    private final Environment env;
    private final RestTemplate restTemplate;

    public ApiClient(Environment env) {
        this.env = env;
        this.restTemplate = new RestTemplate();
        this.apiExternalUrl = env.getProperty("api.external.url");
    }

    public UserApiResponse getExternalUsers() throws RestException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "sample");

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        try {
            ResponseEntity<UserApiResponse> responseEntity = restTemplate.exchange(apiExternalUrl, HttpMethod.GET, entity, UserApiResponse.class);
            return responseEntity.getBody();
        } catch (Exception e) {
            String exceptionName = "Exception";
            if (e instanceof HttpServerErrorException) exceptionName = "HttpServerErrorException";
            if (e instanceof ResourceAccessException) exceptionName = "ResourceAccessException";

            throw new RestException(String.format("Ocurrió un error al acceder al recurso externo %s. Excepcion aproximada: %s", apiExternalUrl, exceptionName), e);

        }
    }

}
