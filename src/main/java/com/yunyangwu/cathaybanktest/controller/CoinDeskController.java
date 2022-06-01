package com.yunyangwu.cathaybanktest.controller;

import com.yunyangwu.cathaybanktest.common.model.CoinDeskResponse;
import com.yunyangwu.cathaybanktest.model.coindesk.CoinDesk;
import com.yunyangwu.cathaybanktest.service.CoinDeskQueryService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.Collections;


@RestController
@RequestMapping("api/v1/coinDesk/CurrentPrice")
@AllArgsConstructor
public class CoinDeskController {

    private static final String baseUrl = "https://api.coindesk.com/v1/bpi/currentprice.json";

    private CoinDeskQueryService coinDeskQueryService;

    @GetMapping
    public CoinDeskResponse getDataFromAPI() throws ParseException {

        MappingJackson2HttpMessageConverter javascriptConverter = new MappingJackson2HttpMessageConverter();
        javascriptConverter.setSupportedMediaTypes(Collections.singletonList(new MediaType("application", "javascript")));
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(javascriptConverter);
        return restTemplate.getForObject(baseUrl, CoinDeskResponse.class);
    }

    @GetMapping("/new")
    public CoinDesk getCoinDeskFromAPI() throws ParseException {
        MappingJackson2HttpMessageConverter javascriptConverter = new MappingJackson2HttpMessageConverter();
        javascriptConverter.setSupportedMediaTypes(Collections.singletonList(new MediaType("application", "javascript")));
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(javascriptConverter);
        CoinDeskResponse response = restTemplate.getForObject(baseUrl, CoinDeskResponse.class);
        CoinDesk coinDesk = coinDeskQueryService.getNewCurrentPriceData(response);
        return coinDesk;
    }
}
