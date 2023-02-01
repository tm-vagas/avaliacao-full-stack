package com.financial.transfers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EnrichReturnDto {

    private Double currentValue;
    private boolean error;

}
