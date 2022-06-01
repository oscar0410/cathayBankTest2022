package com.yunyangwu.cathaybanktest.service;

import com.yunyangwu.cathaybanktest.common.model.CoinDeskResponse;
import com.yunyangwu.cathaybanktest.common.utils.CoinDeskUtils;
import com.yunyangwu.cathaybanktest.model.coindesk.CoinDesk;
import com.yunyangwu.cathaybanktest.model.currency.Currency;
import com.yunyangwu.cathaybanktest.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
@AllArgsConstructor
public class CoinDeskQueryService {

    @Autowired
    CurrencyRepository currencyRepository;

    public CoinDesk getNewCurrentPriceData(CoinDeskResponse response) throws ParseException {
        // Create CoinDesk Object
        CoinDesk rtnCoinDesk = new CoinDesk();

        CoinDeskUtils.datStringToDate(rtnCoinDesk, response);
        CoinDeskUtils.getBpiDateFromResponse(rtnCoinDesk, response);

        rtnCoinDesk.getBpi().forEach((key, value) -> {
            Currency currency = currencyRepository.findByCode(value.getCode());
            String name = currency == null ? null : currency.getName();
            value.setName(name);
        });

        return rtnCoinDesk;
    }
}
