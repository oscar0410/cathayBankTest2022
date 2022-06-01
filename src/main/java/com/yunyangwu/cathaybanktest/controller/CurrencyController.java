package com.yunyangwu.cathaybanktest.controller;

import com.yunyangwu.cathaybanktest.service.CurrencyOperaService;
import com.yunyangwu.cathaybanktest.service.CurrencyQueryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/currency")
@AllArgsConstructor
public class CurrencyController {

    private CurrencyOperaService operationService;

    private CurrencyQueryService queryService;
}
