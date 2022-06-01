package com.yunyangwu.cathaybanktest.service;

import com.yunyangwu.cathaybanktest.common.model.CoinDeskResponse;
import com.yunyangwu.cathaybanktest.common.utils.CoinDeskUtils;
import com.yunyangwu.cathaybanktest.model.coindesk.CoinDesk;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
@Data
public class CoinDeskService {

    public CoinDesk getDataFromResponse(CoinDeskResponse response) throws ParseException {
        // Create CoinDesk Object
        CoinDesk rtnCoinDesk = new CoinDesk();

        CoinDeskUtils.datStringToDate(rtnCoinDesk, response);
        CoinDeskUtils.getBpiDateFromResponse(rtnCoinDesk, response);
        rtnCoinDesk.setChartName(response.getChartName());
        rtnCoinDesk.setDisclaimer(response.getDisclaimer());

        return rtnCoinDesk;
    }
}
