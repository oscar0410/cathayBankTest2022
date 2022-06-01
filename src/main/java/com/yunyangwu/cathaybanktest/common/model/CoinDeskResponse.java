package com.yunyangwu.cathaybanktest.common.model;

import com.yunyangwu.cathaybanktest.model.coindesk.CoinDeskBpi;
import com.yunyangwu.cathaybanktest.model.coindesk.CoinDeskTime;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
public class CoinDeskResponse {

    private CoinDeskTimeResponse time;

    private String disclaimer;

    private String chartName;

    private Map<String, CoinDeskBpiResponse> bpi;


}
