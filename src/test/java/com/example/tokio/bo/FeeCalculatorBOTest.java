package com.example.tokio.bo;

import com.example.tokio.excepion.FeeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeeCalculatorBOTest {

    @Test
    void feeSameDayTest() throws FeeException {
        assertEquals(3.3, FeeCalculatorBO.getFee(0, 10.0)); // 0 days
    }

    @Test
    void feeMoreThanOneAndLessThanTenTest() throws FeeException {
        assertEquals(12, FeeCalculatorBO.getFee(1, 10.0)); // 1 day
        assertEquals(12, FeeCalculatorBO.getFee(10, 10.0)); // 10 days
    }

    @Test
    void feeMoreThanTenAndLessThanTwentyTest() throws FeeException {
        assertEquals(0.82, FeeCalculatorBO.getFee(11, 10.0)); // 11 days
        assertEquals(0.82, FeeCalculatorBO.getFee(20, 10.0)); // 20 days
    }

    @Test
    void feeMoreThanTwentyAndLessThanThirtyTest() throws FeeException {
        assertEquals(0.69, FeeCalculatorBO.getFee(21, 10.0)); // 21 days
        assertEquals(0.69, FeeCalculatorBO.getFee(29, 10.0)); // 29 days
    }

    @Test
    void feeMoreThanThirtyAndLessThanFortyTest() throws FeeException {
        assertEquals(0.47, FeeCalculatorBO.getFee(31, 10.0)); // 31 days
        assertEquals(0.47, FeeCalculatorBO.getFee(39, 10.0)); // 39 days
    }

    @Test
    void feeMoreThanFortyTest() throws FeeException {
        assertEquals(0.17, FeeCalculatorBO.getFee(51, 10.0)); // 51 days
        assertEquals(0.17, FeeCalculatorBO.getFee(58, 10.0)); // 58 days
    }

    @Test
    void feeTypeATest() {
        assertEquals(3.3, FeeCalculatorBO.feeTypeA(10.0)); // 0 days
    }

    @Test
    void feeTypeBTest() {
        assertEquals(12, FeeCalculatorBO.feeTypeB()); // 10 days
    }

    @Test
    void feeTypeCTest() {
        assertEquals(0.82, FeeCalculatorBO.feeTypeC(10.0, FeeCalculatorBO.ABOVE_TEN_DAYS)); // +10 days
        assertEquals(0.69, FeeCalculatorBO.feeTypeC(10.0, FeeCalculatorBO.ABOVE_TWENTY_DAYS)); // +20 days
        assertEquals(0.47, FeeCalculatorBO.feeTypeC(10.0, FeeCalculatorBO.ABOVE_THIRTY_DAYS)); // +30 days
        assertEquals(0.17, FeeCalculatorBO.feeTypeC(10.0, FeeCalculatorBO.ABOVE_FORTY_DAYS)); // +40 days
    }

    @Test
    void amountUpto1000Test() throws FeeException {
        assertEquals(33.0, FeeCalculatorBO.feeByAmount("2020-05-10 15:00:00.000","2020-05-10 15:00:00.000",1000.0)); // 0 days
    }

    @Test
    void amountFrom1001To2000Test() throws FeeException {
        assertEquals(12.0, FeeCalculatorBO.feeByAmount("2020-05-10 15:00:00.000","2020-05-10 15:00:00.000",1001.0)); // 0 days
        assertEquals(12.0, FeeCalculatorBO.feeByAmount("2020-05-10 15:00:00.000","2020-05-10 15:00:00.000",2000.0)); // 0 days
    }

    @Test
    void amountGreaterThan2000Test() throws FeeException {
        assertEquals(164.08, FeeCalculatorBO.feeByAmount("2020-05-10 15:00:00.000","2020-05-10 15:00:00.000",2001.0)); // 0 days
        assertEquals(246.00, FeeCalculatorBO.feeByAmount("2020-05-10 15:00:00.000","2020-05-10 15:00:00.000",3000.0)); // 0 days

        assertEquals(138.07, FeeCalculatorBO.feeByAmount("2020-05-10 15:00:00.000","2020-05-31 15:00:00.000",2001.0)); // 21 days
        assertEquals(207.00, FeeCalculatorBO.feeByAmount("2020-05-10 15:00:00.000","2020-05-31 15:00:00.000",3000.0)); // 21 days

        assertEquals(94.05, FeeCalculatorBO.feeByAmount("2020-05-10 15:00:00.000","2020-06-11 15:00:00.000",2001.0));  // 32 days
        assertEquals(141.00, FeeCalculatorBO.feeByAmount("2020-05-10 15:00:00.000","2020-06-11 15:00:00.000",3000.0)); // 32 days

        assertEquals(34.02, FeeCalculatorBO.feeByAmount("2020-05-10 15:00:00.000","2020-06-21 15:00:00.000",2001.0));  // 41 days
        assertEquals(51.00, FeeCalculatorBO.feeByAmount("2020-05-10 15:00:00.000","2020-06-21 15:00:00.000",3000.0));  // 41 days
    }
}