package com.tokio.service;

import com.tokio.entity.AgendaTransferencia;

import java.util.List;

public interface AgendaTransferenciaService {
    void save(AgendaTransferencia agendaTransferencia);

    List<AgendaTransferencia> findAll();


}
