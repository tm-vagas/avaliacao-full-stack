package com.financial.transfers.service;


import com.financial.transfers.dto.EnrichReturnDto;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface TransfersEnrichService {
    public EnrichReturnDto caseA (Double value);
    public EnrichReturnDto caseB (Double value, String transfersDate) throws ParseException;
    public EnrichReturnDto caseC (Double value, String transfersDate) throws ParseException;
    public EnrichReturnDto caseD (Double value, String transfersDate) throws ParseException;
}
