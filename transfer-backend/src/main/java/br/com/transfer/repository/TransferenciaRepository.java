package br.com.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.transfer.entity.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {

}