package com.yunyangwu.cathaybanktest.common.utils;

import com.yunyangwu.cathaybanktest.common.model.CoinDeskBpiResponse;
import com.yunyangwu.cathaybanktest.common.model.CoinDeskResponse;
import com.yunyangwu.cathaybanktest.common.model.CoinDeskTimeResponse;
import com.yunyangwu.cathaybanktest.model.coindesk.CoinDesk;
import com.yunyangwu.cathaybanktest.model.coindesk.CoinDeskBpi;
import com.yunyangwu.cathaybanktest.model.coindesk.CoinDeskTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CoinDeskUtils {

    private static final DateFormat DF_UTC = new SimpleDateFormat("MMMM d, yyyy hh:mm:ss 'UTC'", Locale.ENGLISH);
    private static final DateTimeFormatter DF_ISO = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
    private static final DateFormat DF_UK = new SimpleDateFormat("MMMM d, yyyy 'at' hh:mm zzz", Locale.ENGLISH);

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
        // ISO
        LocalDateTime localDate = LocalDateTime.parse(timeResponse.getUpdatedISO(), DF_ISO);
        Instant instant = localDate.atZone(ZoneId.systemDefault()).toInstant();
        Date dateISO = Date.from(instant);
        // UK
        DF_UK.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Europe/London")));
        Date dateUK = DF_UK.parse(timeResponse.getUpdateduk());
        // Create CoinDeskTime Object
        CoinDeskTime coinDeskTime = new CoinDeskTime();
        coinDeskTime.setUpdated(dateUTC);
        coinDeskTime.setUpdatedISO(dateISO);
        coinDeskTime.setUpdatedUK(dateUK);

        coinDesk.setTime(coinDeskTime);
    }
}
