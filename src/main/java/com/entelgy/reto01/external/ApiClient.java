package com.entelgy.reto01.external;

import com.entelgy.reto01.model.UserApiResponse;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class ApiClient {
    private final RestTemplate restTemplate;

    public ApiClient() {
        this.restTemplate = new RestTemplate();
    }

    public UserApiResponse getData(String url) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "sample");

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<UserApiResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, UserApiResponse.class);
        return responseEntity.getBody();
    }
}
