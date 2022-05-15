package com.example.tokio.util;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Util {

    /**
     * Get current date in the format ISO 8601, yyyy-MM-dd HH:mm:ss.SSS.
     *
     * @return the current date
     */
    public static String getCurrentDate() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(new Date(System.currentTimeMillis()));
    }

    // convert timestamp to date and time using this format 0000-00-00 00:00:00.000
    public static String convertTime(long timestamp) {

        Date date = new Date(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(date);
    }

    // days to timestamp seconds conversion
    public static long daysToSeconds(int days) {

        return (long) days * 24 * 60 * 60;
    }

    /**
     * Calculate the number of days between two dates (inclusive) and return the result as an int.
     *
     * @param currentDate the current date
     * @param appointmentDate the appointment date
     * @return the number of days between the two dates
     */
    public static int getDays(String currentDate, String appointmentDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = sdf.parse(currentDate);
            d2 = sdf.parse(appointmentDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (d1 == null || d2 == null) {
            return 0;
        }

        long diff = d2.getTime() - d1.getTime();
        return (int) (diff / (1000 * 60 * 60 * 24));
    }

    public static int randomNumber(int number) {

        StringBuilder value = new StringBuilder();

        for (int i = 0; i < number; i++) {
            value.append((int)(Math.random() * 10));
        }
        BigInteger bi = new BigInteger(value.toString());
        return bi.intValue();
    }
}
