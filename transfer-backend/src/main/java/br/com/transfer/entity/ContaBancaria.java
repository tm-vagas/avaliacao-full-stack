package br.com.transfer.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "conta_bancaria")
@SequenceGenerator(name = "sequence_cba_id", sequenceName = "sequence_cba", initialValue = 100000, allocationSize = 1)
public class ContaBancaria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_cba_id")
	@Column(name = "cba_id")
	private Integer id;
	
	@Column(name = "cba_saldo", nullable = false)
	private Double saldo;
	
	@OneToMany()
	@JoinColumn(name = "cba_origem")	 
	private List<Transferencia> transferenciasOrigem;
	
	@OneToMany()
	@JoinColumn(name = "cba_destino")	 
	private List<Transferencia> transferenciasDestino;
	
	public ContaBancaria() {		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public List<Transferencia> getTransferenciasOrigem() {
		return transferenciasOrigem;
	}

	public void setTransferenciasOrigem(List<Transferencia> transferenciasOrigem) {
		this.transferenciasOrigem = transferenciasOrigem;
	}

	public List<Transferencia> getTransferenciasDestino() {
		return transferenciasDestino;
	}

	public void setTransferenciasDestino(List<Transferencia> transferenciasDestino) {
		this.transferenciasDestino = transferenciasDestino;
	}

}