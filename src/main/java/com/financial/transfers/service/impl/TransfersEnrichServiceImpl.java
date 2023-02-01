package com.financial.transfers.service.impl;

import com.financial.transfers.dto.EnrichReturnDto;
import com.financial.transfers.service.TransfersEnrichService;
import com.financial.transfers.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class TransfersEnrichServiceImpl implements TransfersEnrichService {


    @Override
    public EnrichReturnDto caseA(Double value) {
        Double value1 = value - 3.00;
        Double value2 = value1 * 0.03;
        Double total = value1 - value2;
        return new EnrichReturnDto(total, false);
    }

    @Override
    public EnrichReturnDto caseB(Double value, String transfersDate) throws ParseException {
        if (DateUtils.getDiffDate(transfersDate) > 1 &&
                DateUtils.getDiffDate(transfersDate) <= 10) {
            Double total = value - 12.00;
            return new EnrichReturnDto(total, false);
        }
        return new EnrichReturnDto(0.00, true);
    }

    @Override
    public EnrichReturnDto caseC(Double value, String transfersDate) throws ParseException {
        if (DateUtils.getDiffDate(transfersDate) > 10 && DateUtils.getDiffDate(transfersDate) <= 19) {
            Double value1 = value * 0.082;
            Double total = value - value1;
            return new EnrichReturnDto(total, false);
        } else if (DateUtils.getDiffDate(transfersDate) > 20 && DateUtils.getDiffDate(transfersDate) <= 29) {
            Double value1 = value * 0.069;
            Double total = value - value1;
            return new EnrichReturnDto(total, false);
        } else if (DateUtils.getDiffDate(transfersDate) > 30 && DateUtils.getDiffDate(transfersDate) <= 39) {
            Double value1 = value * 0.047;
            Double total = value - value1;
            return new EnrichReturnDto(total, false);
        } else if (DateUtils.getDiffDate(transfersDate) > 40) {
            Double value1 = value * 0.017;
            Double total = value - value1;
            return new EnrichReturnDto(total, false);
        }
        return new EnrichReturnDto(0.00, true);
    }

    @Override
    public EnrichReturnDto caseD(Double value, String transfersDate) throws ParseException {
        if (value <= 1000) {
            return caseA(value);
        } else if (value >= 1001 && value <= 2000) {
            return caseB(value, transfersDate);
        } else if (value >= 2000) {
            return caseC(value, transfersDate);
        }
        return new EnrichReturnDto(0.00, true);
    }
}
