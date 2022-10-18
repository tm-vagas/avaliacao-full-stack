package br.com.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.transfer.entity.ContaBancaria;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Integer> {

}