package com.financial.transfers.service;

import com.financial.transfers.dto.EnrichReturnDto;
import com.financial.transfers.utils.enuns.TransfersType;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface TransfersValidatorService {
    public EnrichReturnDto validator(Double value, String transfersDate, TransfersType transfersType) throws ParseException;
}
