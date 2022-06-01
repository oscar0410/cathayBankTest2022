package com.yunyangwu.cathaybanktest.common.utils;

import com.yunyangwu.cathaybanktest.common.model.CoinDeskBpiResponse;
import com.yunyangwu.cathaybanktest.common.model.CoinDeskResponse;
import com.yunyangwu.cathaybanktest.common.model.CoinDeskTimeResponse;
import com.yunyangwu.cathaybanktest.model.coindesk.CoinDesk;
import com.yunyangwu.cathaybanktest.model.coindesk.CoinDeskBpi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CoinDeskUtils {

    private static final DateFormat DF_UTC = new SimpleDateFormat("MMMM d, yyyy hh:mm:ss 'UTC'", Locale.ENGLISH);

    public static void getBpiDateFromResponse(CoinDesk coinDesk, CoinDeskResponse response) {
        Map<String, CoinDeskBpi> coinDeskBpiMap = new HashMap<>();
        Map<String, CoinDeskBpiResponse> bpiResponse = response.getBpi();
        // Get BPI Data From Response
        bpiResponse.forEach((key, value) -> coinDeskBpiMap.put(key, new CoinDeskBpi(value)));

        coinDesk.setBpi(coinDeskBpiMap);
    }

    public static void datStringToDate(CoinDesk coinDesk, CoinDeskResponse coinDeskResponse) throws ParseException {
        CoinDeskTimeResponse timeResponse = coinDeskResponse.getTime();
        // UTC
        Date dateUTC = DF_UTC.parse(timeResponse.getUpdated());
        coinDesk.setUpdatedDate(dateUTC);

    }
}
