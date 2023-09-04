package br.com.transfer.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tra_id")
	private Integer id;	
	
	@Column(name = "tra_data_agenda", nullable = false)
	private LocalDate dataAgenda;
	
	@Column(name = "tra_data_conclusao", nullable = false)
	private LocalDate dataConclusao;
	
	@Column(name = "tra_valor", nullable = false)
	private Double valor;
	
	@Column(name = "tra_taxa", nullable = false)
	private Double taxa;
	
	@Column(name = "tra_valor_total", nullable = false)
	private Double valorTotal;
	
	@Column(name = "tra_status", nullable = false, length = 9)
	private String status;
	
	public Transferencia() {		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataAgenda() {
		return dataAgenda;
	}

	public void setDataAgenda(LocalDate dataAgenda) {
		this.dataAgenda = dataAgenda;
	}

	public LocalDate getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	

}