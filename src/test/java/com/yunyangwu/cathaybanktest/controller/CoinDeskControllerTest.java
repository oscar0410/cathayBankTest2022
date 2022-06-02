package com.yunyangwu.cathaybanktest.controller;

import com.yunyangwu.cathaybanktest.common.model.CoinDeskResponse;
import com.yunyangwu.cathaybanktest.model.coindesk.CoinDesk;
import com.yunyangwu.cathaybanktest.repository.CurrencyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoinDeskControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Test
    public void testCallCoinDeskAPI() throws Exception {
        String url = "http://localhost:" + port + "/api/v1/coinDesk/CurrentPrice";
        System.out.println(url);
        CoinDeskResponse response = testRestTemplate.getForObject(url, CoinDeskResponse.class);
        Assertions.assertNotNull(response);
        System.out.println(response.toString());
    }

    @Test
    public void testCallNewCoinDeskAPI() throws Exception {
        String url = "http://localhost:" + port + "/api/v1/coinDesk/CurrentPrice/new";
        System.out.println(url);
        CoinDesk response = testRestTemplate.getForObject(url, CoinDesk.class);
        Assertions.assertNotNull(response);
        System.out.println(response.toString());
    }
}
