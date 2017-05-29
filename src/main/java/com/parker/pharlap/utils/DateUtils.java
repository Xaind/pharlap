package com.parker.pharlap.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private DateUtils() {}
    
    public static String format(Date date) {
        return new SimpleDateFormat("ddMMyy").format(date);
    }
    
}
