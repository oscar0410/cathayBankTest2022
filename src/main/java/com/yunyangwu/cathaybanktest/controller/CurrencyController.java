package com.yunyangwu.cathaybanktest.controller;

import com.yunyangwu.cathaybanktest.common.model.CurrencyResponse;
import com.yunyangwu.cathaybanktest.model.currency.Currency;
import com.yunyangwu.cathaybanktest.service.CurrencyOperaService;
import com.yunyangwu.cathaybanktest.service.CurrencyQueryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/currency")
@AllArgsConstructor
public class CurrencyController {

    private CurrencyOperaService operationService;

    private CurrencyQueryService queryService;

    @GetMapping
    public List<CurrencyResponse> findAll(){
        List<CurrencyResponse> rtnList = queryService.findAll().stream().map(CurrencyResponse::new).collect(Collectors.toList());
        return rtnList;
    }

    @GetMapping("/{code}")
    public CurrencyResponse findByCode(@PathVariable(name = "code") String code){
        Currency currency = queryService.findByCode(code);
        return currency!=null ? new CurrencyResponse(currency) : null;
    }
}
