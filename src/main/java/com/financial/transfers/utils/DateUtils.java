package com.financial.transfers.utils;

import org.joda.time.DateTime;
import org.joda.time.Days;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String toString(Date date) {
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        return out.format(date);
    }

    public static Date toDate(String date) throws ParseException {
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        return out.parse(date);
    }

    public static int getDiffDate(String transfersDate) throws ParseException {
        Date date = new Date();
        DateTime initialDateTime = new DateTime(date);
        DateTime finalDateTime = new DateTime(toDate(transfersDate));

        return Days.daysBetween(initialDateTime, finalDateTime).getDays();
    }
}
