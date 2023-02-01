package com.financial.transfers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransfersResponseDto {
    private String status;
    private Boolean error;
}
