package br.com.transfer.service;

import java.util.List;

import br.com.transfer.entity.ContaBancaria;

public interface ContaBancariaService {
	
	ContaBancaria createContaBancaria(Integer usuarioId, ContaBancaria contaBancaria);

    ContaBancaria updateContaBancaria(Integer contaBancariaId, ContaBancaria contaBancaria);

    void deleteContaBancaria(Integer contaBancariaId);

    List<ContaBancaria> getContasBancarias();

    ContaBancaria getContaBancariaById(Integer contaBancariaId);

}