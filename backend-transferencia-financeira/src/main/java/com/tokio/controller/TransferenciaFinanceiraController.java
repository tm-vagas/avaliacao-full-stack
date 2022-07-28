package com.tokio.controller;

import com.tokio.dto.AgendaTransferenciaDTO;
import com.tokio.entity.AgendaTransferencia;
import com.tokio.exception.CalculoTaxaException;
import com.tokio.service.AgendaTransferenciaService;
import com.tokio.service.CalculoTaxaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(path = "api/transferencia")
@Slf4j
public class TransferenciaFinanceiraController {
    @Autowired
    private AgendaTransferenciaService agendaTransferenciaService;

    @Autowired
    private CalculoTaxaService calculoTaxaService;

    @PostMapping("/agendamento")
    public ResponseEntity<String> criaAgendamento(@RequestBody AgendaTransferenciaDTO agendaTransferenciaDTO) {

        try {
            AgendaTransferencia agendaTransferencia = agendaTransferenciaDTO.toAgendaTransferencia();
            agendaTransferencia.setDataAgendamento(new Date());

            BigDecimal taxa = calculoTaxaService.calculoTaxaD(agendaTransferencia);

            if (Objects.nonNull(taxa)) {
                agendaTransferencia.setTaxa(taxa);
            } else {
                throw new CalculoTaxaException("Erro no calculo e aplicacao da taxa");
            }

            agendaTransferenciaService.save(agendaTransferencia);
        }catch (CalculoTaxaException ct) {
            return ResponseEntity.unprocessableEntity().body(ct.getMessage());
        }catch (Exception e) {
           log.error(e.getMessage(),e.fillInStackTrace());
           return ResponseEntity.internalServerError().body("Erro no agendamento");
        }

        return ResponseEntity.ok("Agendamento de transferencia efetuado com sucesso");
    }

    @GetMapping("/lista-agendamentos")
    public List<AgendaTransferencia> getAgendamentos() {
        return agendaTransferenciaService.findAll();
    }
}
