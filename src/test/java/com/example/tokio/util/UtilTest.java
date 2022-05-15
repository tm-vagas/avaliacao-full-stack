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
        int n = 100;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Util.randomNumber(10);
        }
        assertTrue(arr[0] >= 0);
    }
}
