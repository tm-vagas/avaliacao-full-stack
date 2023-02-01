package com.financial.transfers.service.impl;

import com.financial.transfers.dto.EnrichReturnDto;
import com.financial.transfers.service.TransfersValidatorService;
import com.financial.transfers.utils.enuns.TransfersType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class TransfersValidatorServiceImpl implements TransfersValidatorService {

    @Autowired
    private TransfersEnrichServiceImpl transfersEnrichService;

    public EnrichReturnDto validator(Double value, String transfersDate, TransfersType transfersType) throws ParseException {
        return switch (transfersType) {
            case A -> transfersEnrichService.caseA(value);
            case B -> transfersEnrichService.caseB(value, transfersDate);
            case C -> transfersEnrichService.caseC(value, transfersDate);
            case D -> transfersEnrichService.caseD(value, transfersDate);
        };
    }
}
