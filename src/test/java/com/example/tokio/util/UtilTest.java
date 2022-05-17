package com.example.tokio.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void getCurrentDateTest() {
        String currentDate = Util.getCurrentDate();
        assertNotNull(currentDate);
    }

    @Test
    void getDaysTest() {
        assertEquals(0, Util.getDays("2020-05-10 15:00:00.000", "2020-05-10 15:00:00.000"));
        assertEquals(1, Util.getDays("2020-05-10 15:00:00.000", "2020-05-11 15:00:00.000"));
        assertEquals(2, Util.getDays("2020-05-10 15:00:00.000", "2020-05-12 15:00:00.000"));
    }

    @Test
    void randomNumber() {
        int n = Util.randomNumber(10);
        assertTrue(n >= 0);
    }

    @Test
    void convertTime() {
        String result = Util.convertTime(1652707181509L);
        assertEquals("2022-05-16 10:19:41.509", result);
    }

    @Test
    void daysToSeconds() {
        long result = Util.daysToSeconds(1);
        assertEquals(86400, result);
    }
}
