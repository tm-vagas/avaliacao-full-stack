package com.tokio.service;

import com.tokio.entity.AgendaTransferencia;
import com.tokio.repository.AgendaTransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaTransferenciaServiceImpl implements AgendaTransferenciaService{

    @Autowired
    private AgendaTransferenciaRepository agendaRepository;

    @Override
    public void save(AgendaTransferencia agendaTransferencia) {
        agendaRepository.save(agendaTransferencia);
    }

    @Override
    public List<AgendaTransferencia> findAll() {
        return agendaRepository.findAll();
    }
}
