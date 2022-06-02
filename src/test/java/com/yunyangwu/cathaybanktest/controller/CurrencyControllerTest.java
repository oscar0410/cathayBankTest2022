package com.yunyangwu.cathaybanktest.controller;

import com.yunyangwu.cathaybanktest.common.model.CurrencyCreateRequest;
import com.yunyangwu.cathaybanktest.common.model.CurrencyPatchRequest;
import com.yunyangwu.cathaybanktest.common.model.CurrencyResponse;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Arrays;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CurrencyControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    @Order(1)
    public void testCreate() throws Exception {
        String url = "http://localhost:" + port + "/api/v1/currency";
        System.out.println("The test url is : " + url);
        CurrencyCreateRequest request = new CurrencyCreateRequest();
        request.setCode("TWD");
        request.setName("新台幣");
        request.setDescription("Test Create Method");
        String message = testRestTemplate.postForObject(url, request, String.class);
        Assertions.assertTrue(message.equalsIgnoreCase("Created Done!"));
    }

    @Test
    @Order(2)
    public void testFindByCode() throws Exception {
        String url = "http://localhost:" + port + "/api/v1/currency/TWD";
        System.out.println("The test url is : " + url);
        CurrencyResponse response = testRestTemplate.getForObject(url, CurrencyResponse.class);
        Assertions.assertNotNull(response);
        System.out.println(response);
    }

    @Test
    @Order(3)
    public void testUpdate() throws Exception {
        String url = "http://localhost:" + port + "/api/v1/currency/TWD";
        System.out.println("The test url is : " + url);
        CurrencyPatchRequest request = new CurrencyPatchRequest();
        request.setCode("TWD");
        request.setName("新台幣");
        request.setDescription("Test Update Method");
        testRestTemplate.put(url, request);
        CurrencyResponse response = testRestTemplate.getForObject(url, CurrencyResponse.class);
        Assertions.assertNotNull(response.getUpdatedDate());
        System.out.println(response);
    }

    @Test
    @Order(4)
    public void testDelete() throws Exception {
        String url = "http://localhost:" + port + "/api/v1/currency/TWD";
        System.out.println("The test url is : " + url);
        testRestTemplate.delete(url);
        Assertions.assertNull(testRestTemplate.getForObject(url, CurrencyResponse.class));
    }

    @Test
    @Order(5)
    public void testFindAll() throws Exception {
        String url = "http://localhost:" + port + "/api/v1/currency";
        System.out.println("The test url is : " + url);
        CurrencyResponse[] response = testRestTemplate.getForObject(url, CurrencyResponse[].class);
        Assertions.assertNotNull(response);
        System.out.println(Arrays.toString(response));
    }


}
