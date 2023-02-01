package com.financial.transfers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceivedTransfersDto {
    private Double value;
    private String targetAccount;
    private String transfersDate;
    private String transfersType;
}
