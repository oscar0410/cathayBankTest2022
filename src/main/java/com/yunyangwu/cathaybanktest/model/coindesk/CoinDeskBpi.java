package com.yunyangwu.cathaybanktest.model.coindesk;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yunyangwu.cathaybanktest.common.model.CoinDeskBpiResponse;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class CoinDeskBpi {

    private String code;
    private String symbol;
    private String rate;
    private String description;
    private BigDecimal rateFloat;

    public CoinDeskBpi(CoinDeskBpiResponse bpiResponse) {
        this.code = bpiResponse.getCode();
        this.symbol = bpiResponse.getSymbol();
        this.rate = bpiResponse.getRate();
        this.description = bpiResponse.getDescription();
        this.rateFloat = bpiResponse.getRateFloat();
    }
}
