package com.yunyangwu.cathaybanktest.model.coindesk;

import com.yunyangwu.cathaybanktest.common.model.CoinDeskBpiResponse;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class CoinDeskBpi {

    private String code;

    private String name;

    private BigDecimal rateFloat;

    public CoinDeskBpi(CoinDeskBpiResponse bpiResponse) {
        this.code = bpiResponse.getCode();
        this.rateFloat = bpiResponse.getRateFloat();
    }
}
