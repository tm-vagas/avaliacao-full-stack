package com.financial.transfers.service;

import com.financial.transfers.dto.ReceivedTransfersDto;
import com.financial.transfers.dto.TransfersResponseDto;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface TransfersService {
    public TransfersResponseDto processTransfers(ReceivedTransfersDto receivedTransfersDto) throws ParseException;
}