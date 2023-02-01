package com.financial.transfers.controller;

import com.financial.transfers.dto.ReceivedTransfersDto;
import com.financial.transfers.dto.ReportDto;
import com.financial.transfers.service.impl.TransfersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class TransfersController {

    @Autowired
    private TransfersServiceImpl transfersService;

    @PostMapping(path = "/transfers")
    public ResponseEntity<?> receivedTransfers(@RequestBody ReceivedTransfersDto receivedTransfersDto) throws ParseException {
        if (transfersService.processTransfers(receivedTransfersDto).getError()) {
            return ResponseEntity.internalServerError().body(new ReportDto("Error!"));
        }
        return ResponseEntity.ok().body(new ReportDto("Sucess!"));
    }
}
