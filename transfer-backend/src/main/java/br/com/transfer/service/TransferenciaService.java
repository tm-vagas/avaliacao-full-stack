package br.com.transfer.service;

import java.util.List;

import br.com.transfer.entity.Transferencia;

public interface TransferenciaService {
	
	Transferencia createTransferencia(Integer contaBancariaOrigemId, Integer contaBancariaDestinoId, Transferencia transferencia);

    Transferencia updateTransferencia(Integer transferenciaId, Transferencia transferencia);

    void deleteTransferencia(Integer transferenciaId);

    List<Transferencia> getTransferencias();

    Transferencia getTransferenciaById(Integer transferenciaId);

}