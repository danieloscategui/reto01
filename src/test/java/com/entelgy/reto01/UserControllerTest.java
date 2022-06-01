package com.entelgy.reto01;

import com.entelgy.reto01.external.model.UserApiResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void testPostUserWithMockRestTemplate() throws Exception {
        ResponseEntity<UserApiResponse> response = new ResponseEntity<>(getMock(), HttpStatus.OK);
        when(restTemplate.exchange(
                eq("https://reqres.in/api/users"),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(UserApiResponse.class)))
                .thenReturn(response);
        mockMvc.perform(post("/reto")).andExpect(status().isOk());
    }

    @Test
    public void testPostUserIsOk() throws Exception {
        mockMvc.perform(post("/reto")).andExpect(status().isOk());
    }

    @Test
    public void testPostUserExistData() throws Exception {
        mockMvc.perform(post("/reto")).andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray());
    }

    private UserApiResponse getMock() {
        UserApiResponse userApiResponse = new UserApiResponse();
        userApiResponse.setPage(1);
        userApiResponse.setPer_page(10);
        userApiResponse.setPer_page(1);
        userApiResponse.setTotal(1);
        userApiResponse.setTotal_pages(10);
        userApiResponse.setData(new HashSet<>());
        return userApiResponse;
    }
}
