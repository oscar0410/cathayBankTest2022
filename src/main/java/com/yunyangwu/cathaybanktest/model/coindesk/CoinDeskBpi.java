package com.yunyangwu.cathaybanktest.model.coindesk;

import com.yunyangwu.cathaybanktest.common.model.CoinDeskBpiResponse;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
