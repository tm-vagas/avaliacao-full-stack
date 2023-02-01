package com.financial.transfers.utils;

import com.financial.transfers.utils.enuns.TransfersType;

public class TransfersTypeUtils {
    public static TransfersType convertToEnum(String type) {
        return switch (type) {
            case "A" -> TransfersType.A;
            case "B" -> TransfersType.B;
            case "C" -> TransfersType.C;
            case "D" -> TransfersType.D;
            default -> throw new IllegalArgumentException("Unexpected value");
        };
    }
}
