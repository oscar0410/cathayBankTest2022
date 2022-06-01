package com.yunyangwu.cathaybanktest.service;

import com.yunyangwu.cathaybanktest.model.currency.Currency;
import com.yunyangwu.cathaybanktest.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
@AllArgsConstructor
public class CurrencyQueryService {

    private CurrencyRepository repository;

    public List<Currency> findAll() {
        return repository.findAll();
    }

    public Currency findByCode(String code) {
        return repository.findByCode(code);
    }
}
