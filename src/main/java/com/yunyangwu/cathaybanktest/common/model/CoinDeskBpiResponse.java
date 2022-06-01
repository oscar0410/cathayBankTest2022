package com.yunyangwu.cathaybanktest.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class CoinDeskBpiResponse {

    private String code;
    private String symbol;
    private String rate;
    private String description;
    @JsonProperty(value = "rate_float")
    private BigDecimal rateFloat;

}
