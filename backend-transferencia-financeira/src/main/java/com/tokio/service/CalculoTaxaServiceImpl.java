package com.tokio.service;

import com.tokio.entity.AgendaTransferencia;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculoTaxaServiceImpl implements CalculoTaxaService {


    @Override
    public BigDecimal calculoTaxaA(AgendaTransferencia agendaTransferencia) {
        Integer days = Days.daysBetween(new DateTime(agendaTransferencia.getDataAgendamento()),new DateTime(agendaTransferencia.getDataTransferencia())).getDays();


        if (days.equals(0)) {
            return new BigDecimal(3).add(agendaTransferencia.getValorTransferencia().multiply(new BigDecimal(0.03)));
        }

        return null;
    }

    @Override
    public BigDecimal calculoTaxaB(AgendaTransferencia agendaTransferencia) {
        Integer days = Days.daysBetween(new DateTime(agendaTransferencia.getDataAgendamento()),new DateTime(agendaTransferencia.getDataTransferencia())).getDays();

        if (days<=10) {
            return new BigDecimal(12);
        }

        return null;
    }

    @Override
    public BigDecimal calculoTaxaC(AgendaTransferencia agendaTransferencia) {
        Integer days = Days.daysBetween(new DateTime(agendaTransferencia.getDataAgendamento()),new DateTime(agendaTransferencia.getDataTransferencia())).getDays();

        if (days > 10 && days <= 20) {
            return agendaTransferencia.getValorTransferencia().multiply(new BigDecimal(0.082));
        }
        if (days > 20 && days <= 30) {
            return agendaTransferencia.getValorTransferencia().multiply(new BigDecimal(0.069));
        }
        if (days > 30 && days <= 40) {
            return agendaTransferencia.getValorTransferencia().multiply(new BigDecimal(0.047));
        }
        if (days > 40) {
            return agendaTransferencia.getValorTransferencia().multiply(new BigDecimal(0.017));
        }

        return null;
    }

    @Override
    public BigDecimal calculoTaxaD(AgendaTransferencia agendaTransferencia){
        if (agendaTransferencia.getValorTransferencia().compareTo(new BigDecimal(1000)) <= 0) {
            return calculoTaxaA(agendaTransferencia);
        }

        if (agendaTransferencia.getValorTransferencia().compareTo(new BigDecimal(1000)) > 0  &&
                agendaTransferencia.getValorTransferencia().compareTo(new BigDecimal(2000)) <= 0) {
            return calculoTaxaB(agendaTransferencia);
        }

        if (agendaTransferencia.getValorTransferencia().compareTo(new BigDecimal(2000)) > 0) {
            return calculoTaxaC(agendaTransferencia);
        }

        return null;
    }
}
