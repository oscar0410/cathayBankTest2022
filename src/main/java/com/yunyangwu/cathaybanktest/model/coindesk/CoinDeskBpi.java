package com.yunyangwu.cathaybanktest.model.coindesk;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(value = "rate_float")
    private BigDecimal rateFloat;

}
