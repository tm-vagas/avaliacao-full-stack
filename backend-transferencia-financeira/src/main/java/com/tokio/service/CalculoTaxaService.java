package com.tokio.service;

import com.tokio.entity.AgendaTransferencia;

import java.math.BigDecimal;

public interface CalculoTaxaService {
    public BigDecimal calculoTaxaA(AgendaTransferencia agendaTransferencia);

    public BigDecimal calculoTaxaB(AgendaTransferencia agendaTransferencia);

    public BigDecimal calculoTaxaC(AgendaTransferencia agendaTransferencia);

    public BigDecimal calculoTaxaD(AgendaTransferencia agendaTransferencia);
}
