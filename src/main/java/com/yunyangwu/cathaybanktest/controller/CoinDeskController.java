package com.yunyangwu.cathaybanktest.controller;

import com.yunyangwu.cathaybanktest.model.coindesk.CoinDesk;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@RestController
@RequestMapping("api/v1/coinDesk")
public class CoinDeskController {


    @GetMapping("/getCurrentPrice")
    public CoinDesk getCoinDeskFromAPI() {

        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
        MappingJackson2HttpMessageConverter javascriptConverter = new MappingJackson2HttpMessageConverter();
        javascriptConverter.setSupportedMediaTypes(Collections.singletonList(new MediaType("application", "javascript")));
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(javascriptConverter);
        CoinDesk coinDesk = restTemplate.getForObject(url, CoinDesk.class);
        return coinDesk;
    }
}
