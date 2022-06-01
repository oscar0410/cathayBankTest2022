package com.yunyangwu.cathaybanktest.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTransFormUtils {

    private static final SimpleDateFormat DF_DISPLAY = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


    public static String date2StrForDTO(Date date) {
        return DF_DISPLAY.format(date);
    }
}
