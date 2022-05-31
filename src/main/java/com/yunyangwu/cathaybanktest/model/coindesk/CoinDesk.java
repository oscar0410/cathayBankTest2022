package com.yunyangwu.cathaybanktest.model.coindesk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
public class CoinDesk {

    private CoinDeskTime time;

    private String disclaimer;

    private String chartName;

    private Map<String, CoinDeskBpi> bpi;


}
