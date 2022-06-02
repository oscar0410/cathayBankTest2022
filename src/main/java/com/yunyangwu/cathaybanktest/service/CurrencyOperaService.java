package com.yunyangwu.cathaybanktest.service;

import com.yunyangwu.cathaybanktest.common.model.CurrencyCreateRequest;
import com.yunyangwu.cathaybanktest.common.model.CurrencyPatchRequest;
import com.yunyangwu.cathaybanktest.model.currency.Currency;
import com.yunyangwu.cathaybanktest.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
@AllArgsConstructor
public class CurrencyOperaService {

    private CurrencyRepository repository;

    public void create(CurrencyCreateRequest request) {
        Date date = new Date();
        Currency currency = new Currency();
        currency.setCode(request.getCode().toUpperCase());
        currency.setDescription(request.getDescription());
        currency.setName(request.getName());
        currency.setCreatedDate(date);
        repository.save(currency);
    }

    public void update(Currency currency, CurrencyPatchRequest request) {
        if (request.getCode()!=null || !"".equalsIgnoreCase(request.getCode()) &&!currency.getCode().equalsIgnoreCase(request.getCode())){
            currency.setCode(request.getCode());
        }
        if (request.getName()!=null || !"".equalsIgnoreCase(request.getName()) && !currency.getName().equalsIgnoreCase(request.getName())){
            currency.setName(request.getName());
        }
        if (request.getDescription()!=null || !"".equalsIgnoreCase(request.getDescription()) &&!currency.getDescription().equalsIgnoreCase(request.getDescription())){
            currency.setDescription(request.getDescription());
        }
        currency.setUpdatedDate(new Date());
        repository.save(currency);
    }

    public void delete(Currency currency) {
        if (currency != null) {
            repository.delete(currency);
        }
    }
}
