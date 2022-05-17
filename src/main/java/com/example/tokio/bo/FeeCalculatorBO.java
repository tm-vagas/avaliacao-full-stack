package com.example.tokio.bo;


import com.example.tokio.excepion.FeeException;

import static com.example.tokio.util.Util.getDays;

public class FeeCalculatorBO {

    private FeeCalculatorBO() {}

    public static final double ABOVE_TEN_DAYS    = 0.082;
    public static final double ABOVE_TWENTY_DAYS = 0.069;
    public static final double ABOVE_THIRTY_DAYS = 0.047;
    public static final double ABOVE_FORTY_DAYS  = 0.017;

    public static double feeTypeA(double transferAmount) {
        return round(3 + (transferAmount * 0.03));
    }

    public static double feeTypeB() {
        return 12;
    }

    public static double feeTypeC(double transferAmount, double percentage) {
        return round(transferAmount * percentage);
    }

    public static double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    /**
     * A: Same-day transfers have a $3 fee plus 3% of the transfer amount.
     * B: Transfers within 10 days of the scheduled date have a $12 fee.
     * C: Type C operations have a regressive rate according to the transfer date:
     * <p>
     *     <ol>
     *         <li>more than 10 days from the appointment date 8.2%</li>
     *         <li>more than 20 days from the appointment date 6.9%</li>
     *         <li>more than 30 days from the appointment date 4.7%</li>
     *         <li>more than 40 days from the appointment date 1.7%</li>
     *     <ol>
     *
     * @param days between transfer date and appointment date
     * @param transferAmount transfer amount
     * @return transfer amount with fee applied
     */
    public static double getFee(int days, double transferAmount) throws FeeException {

        try {
            if (days == 0) {
                return feeTypeA(transferAmount);
            } else if (days >= 1 && days <= 10) {
                return feeTypeB();
            } else if (days == 20 || (days > 10 && days < 20)) {
                return feeTypeC(transferAmount, ABOVE_TEN_DAYS);
            } else if (days == 30 || (days > 20 && days < 30)) {
                return feeTypeC(transferAmount, ABOVE_TWENTY_DAYS);
            } else if (days == 40 || (days > 30 && days < 40)) {
                return feeTypeC(transferAmount, ABOVE_THIRTY_DAYS);
            } else if (days > 40) {
                return feeTypeC(transferAmount, ABOVE_FORTY_DAYS);
            } else {
                throw new FeeException("No applicable fee");
            }
        } catch (FeeException e) {
            throw new FeeException(e.getMessage());
        }
    }

    /**
     * A: Same-day transfers have a $3 fee plus 3% of the transfer amount.
     * B: Transfers within 10 days of the scheduled date have a $12 fee.
     * C: Type C operations have a regressive rate according to the transfer date:
     * <p>
     *     <ol>
     *         <li>more than 10 days from the appointment date 8.2%</li>
     *         <li>more than 20 days from the appointment date 6.9%</li>
     *         <li>more than 30 days from the appointment date 4.7%</li>
     *         <li>more than 40 days from the appointment date 1.7%</li>
     *     <ol>
     *
     * @param days between transfer date and appointment date
     * @param transferAmount transfer amount
     * @return transfer amount with fee applied
     * @throws FeeException if no applicable fee
     */
    public static double getFeeTypeC(int days, double transferAmount) throws FeeException {
        try {
            if (days == 0) {
                return feeTypeC(transferAmount, ABOVE_TEN_DAYS);
            } else if (days > 1 && days < 10) {
                return feeTypeC(transferAmount, ABOVE_TEN_DAYS);
            } else if (days > 10 && days < 20) {
                return feeTypeC(transferAmount, ABOVE_TEN_DAYS);
            } else if (days > 20 && days < 30) {
                return feeTypeC(transferAmount, ABOVE_TWENTY_DAYS);
            } else if (days > 30 && days < 40) {
                return feeTypeC(transferAmount, ABOVE_THIRTY_DAYS);
            } else if (days > 40) {
                return feeTypeC(transferAmount, ABOVE_FORTY_DAYS);
            } else {
                throw new FeeException("No applicable fee");
            }
        } catch (FeeException e) {
            throw new FeeException(e.getMessage());
        }
    }

    /**
     * A: Same-day amount is less than $1,000 then apply fee of 3 + 3% of the transfer amount.
     * B: Same-day amount is less than $2,000 then apply fee of 12.
     * C: Same-day amount is greater than $2,000 then apply fee of 3 + 3% of the transfer amount.
     * <p>
     *     <ol>
     *         <li>transfer amount is less than $1,000 then apply fee of 3 + 3% of the transfer amount</li>
     *         <li>transfer amount is less than $2,000 then apply fee of 12</li>
     *         <li>transfer amount is greater than $2,000 then apply fee of 3 + 3% of the transfer amount</li>
     *     <ol>
     *
     * @param currentDate current date
     * @param appointmentDate appointment date
     * @param transferAmount transfer amount
     * @return transfer amount with fee applied
     * @throws FeeException if no applicable fee
     */
    public static double feeByAmount(String currentDate, String appointmentDate, double transferAmount) throws FeeException {
        try {
            int days = getDays(currentDate, appointmentDate);
            if (transferAmount <= 1000) {
                return feeTypeA(transferAmount);
            } else if (transferAmount > 1000 && transferAmount <= 2000) {
                return feeTypeB();
            } else if (transferAmount > 2000) {
                return getFeeTypeC(days, transferAmount);
            } else {
                throw new FeeException("No applicable fee");
            }
        } catch (FeeException e) {
            throw new FeeException(e.getMessage());
        }
    }
}
