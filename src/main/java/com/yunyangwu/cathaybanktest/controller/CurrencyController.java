package com.yunyangwu.cathaybanktest.controller;

import com.yunyangwu.cathaybanktest.common.model.CurrencyCreateRequest;
import com.yunyangwu.cathaybanktest.common.model.CurrencyPatchRequest;
import com.yunyangwu.cathaybanktest.common.model.CurrencyResponse;
import com.yunyangwu.cathaybanktest.model.currency.Currency;
import com.yunyangwu.cathaybanktest.service.CurrencyOperaService;
import com.yunyangwu.cathaybanktest.service.CurrencyQueryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/currency")
@AllArgsConstructor
@Validated
public class CurrencyController {

    private CurrencyOperaService operationService;

    private CurrencyQueryService queryService;


    @GetMapping
    public List<CurrencyResponse> findAll() {
        return queryService.findAll().stream().map(CurrencyResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/{code}")
    public CurrencyResponse findByCode(@PathVariable(name = "code") String code) {
        Currency currency = queryService.findByCode(code);
        return currency != null ? new CurrencyResponse(currency) : null;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String create(@Valid @RequestBody CurrencyCreateRequest request) {
        Currency currency = queryService.findByCode(request.getCode());
        if (currency == null) {
            operationService.create(request);
            return "Created Done!";
        }
        return "";
    }

    @PutMapping("/{code}")
    public Currency update(@RequestBody CurrencyPatchRequest request) {
        Currency currency = queryService.findByCode(request.getCode());
        if (currency != null) {
            operationService.update(currency, request);
        }
        return currency;

    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable(name = "code") String code) {
        Currency currency = queryService.findByCode(code.toUpperCase());
        operationService.delete(currency);
    }
}
