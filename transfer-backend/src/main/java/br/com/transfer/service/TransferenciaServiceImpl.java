package br.com.transfer.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transfer.entity.ContaBancaria;
import br.com.transfer.entity.Transferencia;
import br.com.transfer.repository.ContaBancariaRepository;
import br.com.transfer.repository.TransferenciaRepository;
import br.com.transfer.service.exception.Exceptions;

@Service
@Transactional
public class TransferenciaServiceImpl implements TransferenciaService {
	
	static final String ERRO_CADASTRO = "Não foi possível realizar o cadastro!";
	static final String ERRO_EDICAO = "Não foi possível realizar a edição!";
    static final String ERRO_EXCLUSAO = "Não foi possível realizar a exclusão!";
    static final String ERRO_PESQUISA = "Não foi possível realizar a pesquisa!";
    static final String INEXISTENCIA_TRANSFERENCIA = " Transferência inexistente.";    
    static final String INEXISTENCIA_CONTAS_BANCARIAS_ORIGEM_DESTINO = " Contas origem e destino inexistentes.";
    static final String INEXISTENCIA_CONTA_BANCARIA_ORIGEM = " Conta origem inexistente.";
    static final String INEXISTENCIA_CONTA_BANCARIA_DESTINO = " Conta destino inexistente.";
    static final String IGUALDADE_CONTAS_BANCARIAS_ORIGEM_DESTINO = " Contas origem e destino iguais.";
    static final String TAXA_TRANSFERENCIA = " Taxa não aplicável.";
    static final String SALDO_CONTA_BANCARIA_ORIGEM = " Saldo insuficiente.";
    static final String DATA_ANTERIOR_TRANSFERENCIA = " Data da transferência é anterior à data atual.";

	@Autowired
	private ContaBancariaRepository contaBancariaRepository;

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	@Override
	public Transferencia createTransferencia(Integer contaBancariaOrigemId, Integer contaBancariaDestinoId,
			Transferencia transferenci) {

		// Valor da transferência
		Double valor = transferenci.getValor();

		// Data da transferência
		LocalDate dataConclusao = transferenci.getDataConclusao();

		// Data atual
		LocalDate dataAtual = LocalDate.now();

		// Verifica se a data de transferência não é anterior à data atual
		if (!(dataConclusao.isBefore(dataAtual))) {

			// Recupera taxa de acordo com o tipo de transferência
			Double taxa = getTaxa(dataAtual, dataConclusao, valor);

			// Verifica se as contas origem e destino existem
			if ((contaBancariaRepository.existsById(contaBancariaOrigemId))
					|| (contaBancariaRepository.existsById(contaBancariaDestinoId))) {
				if (contaBancariaRepository.existsById(contaBancariaOrigemId)) {
					if (contaBancariaRepository.existsById(contaBancariaDestinoId)) {

						// Verifica se as contas origem e destino não são iguais
						if (!(contaBancariaOrigemId.equals(contaBancariaDestinoId))) {

							// Verifica se a taxa é aplicável
							if (taxa > 0) {

								// Valor total da transferência
								Double valorTotal = valor + taxa;

								// Recupera contas origem e destino
								ContaBancaria contaBancariaOrigem = contaBancariaRepository
										.findById(contaBancariaOrigemId).get();
								ContaBancaria contaBancariaDestino = contaBancariaRepository
										.findById(contaBancariaDestinoId).get();

								// Verifica se a conta origem tem saldo suficiente
								if (verifySaldoSuficiente(valorTotal, contaBancariaOrigem.getSaldo())) {

									// Define novo saldo para a conta origem
									Double novoSaldoContaOrigem = contaBancariaOrigem.getSaldo() - valorTotal;
									contaBancariaOrigem.setSaldo(novoSaldoContaOrigem);

									// Atualiza o saldo da conta origem
									contaBancariaRepository.save(contaBancariaOrigem);

									// Cria a transferência
									Transferencia transferencia = new Transferencia();
									transferencia.setDataAgenda(dataAtual);
									transferencia.setDataConclusao(dataConclusao);
									transferencia.setValor(valor);
									transferencia.setTaxa(taxa);
									transferencia.setValorTotal(valorTotal);

									// Verifica se a transferência é agendada
									if (!(dataAtual.equals(dataConclusao))) {

										// Seta o status da transferência como "Agendada"
										transferencia.setStatus("Agendada");

										// Agenda a tarefa
										Calendar calendar = Calendar.getInstance();
										calendar.set(dataConclusao.getYear(), dataConclusao.getMonthValue() - 1,
												dataConclusao.getDayOfMonth(), 00, 00);
										Date time = calendar.getTime();
										Timer timer = new Timer();
										timer.schedule(new TimerTask() {
											public void run() {

												// Define novo saldo para a conta destino
												Double novoSaldoContaDestino = contaBancariaDestino.getSaldo()
														+ valorTotal;
												contaBancariaDestino.setSaldo(novoSaldoContaDestino);

												// Atualiza o saldo da conta destino
												contaBancariaRepository.save(contaBancariaDestino);

												// Atualiza o status da transferência
												transferencia.setStatus("Concluído");

												// Grava a transferência no database
												transferenciaRepository.save(transferencia);
											}
										}, time);

									} else {

										// Define novo saldo para a conta destino
										Double novoSaldoContaDestino = contaBancariaDestino.getSaldo() + valorTotal;
										contaBancariaDestino.setSaldo(novoSaldoContaDestino);

										// Seta o status da transferência como "Concluído"
										transferencia.setStatus("Concluído");
									}

									// Grava a transferência no database
									transferenciaRepository.save(transferencia);

									// Cria listas de transferências
									List<Transferencia> transferenciasOrigem = new ArrayList<>();
									List<Transferencia> transferenciasDestino = new ArrayList<>();

									// Adiciona a transferência às listas
									transferenciasOrigem.add(transferencia);
									transferenciasDestino.add(transferencia);

									// Associa listas às contas
									contaBancariaOrigem.setTransferenciasOrigem(transferenciasOrigem);
									contaBancariaDestino.setTransferenciasDestino(transferenciasDestino);

									// Atualiza contas
									contaBancariaRepository.save(contaBancariaOrigem);
									contaBancariaRepository.save(contaBancariaDestino);

									// Retorna a transferência
									return transferenciaRepository.save(transferencia);

								} else {
									throw new Exceptions(406, ERRO_CADASTRO.concat(SALDO_CONTA_BANCARIA_ORIGEM));
								}
							} else {
								throw new Exceptions(406, ERRO_CADASTRO.concat(TAXA_TRANSFERENCIA));
							}
						} else {
							throw new Exceptions(406, ERRO_CADASTRO.concat(IGUALDADE_CONTAS_BANCARIAS_ORIGEM_DESTINO));
						}
					} else {
						throw new Exceptions(404, ERRO_CADASTRO.concat(INEXISTENCIA_CONTA_BANCARIA_DESTINO));
					}
				} else {
					throw new Exceptions(404, ERRO_CADASTRO.concat(INEXISTENCIA_CONTA_BANCARIA_ORIGEM));
				}
			} else {
				throw new Exceptions(404, ERRO_CADASTRO.concat(INEXISTENCIA_CONTAS_BANCARIAS_ORIGEM_DESTINO));
			}

		} else {
			throw new Exceptions(406, ERRO_CADASTRO.concat(DATA_ANTERIOR_TRANSFERENCIA));
		}

	}

	@Override
	public Transferencia updateTransferencia(Integer transferenciaId, Transferencia transferencia) {
		Optional<Transferencia> transferenciaDb = transferenciaRepository.findById(transferenciaId);
		if (transferenciaDb.isPresent()) {
			Transferencia transferenciaUpdate = transferenciaDb.get();
			transferenciaUpdate.setId(transferencia.getId());
			transferenciaUpdate.setDataAgenda(transferencia.getDataAgenda());
			transferenciaUpdate.setDataConclusao(transferencia.getDataConclusao());
			transferenciaUpdate.setValor(transferencia.getValor());
			transferenciaUpdate.setTaxa(transferencia.getTaxa());
			transferenciaUpdate.setValorTotal(transferencia.getValorTotal());
			transferenciaUpdate.setStatus(transferencia.getStatus());
			transferenciaRepository.save(transferenciaUpdate);
			return transferenciaUpdate;
		} else {
			throw new Exceptions(404, ERRO_EDICAO.concat(INEXISTENCIA_TRANSFERENCIA));
		}
	}

	@Override
	public void deleteTransferencia(Integer transferenciaId) {
		Optional<Transferencia> transferenciaDb = transferenciaRepository.findById(transferenciaId);
		if (transferenciaDb.isPresent()) {
			transferenciaRepository.delete(transferenciaDb.get());
		} else {
			throw new Exceptions(404, ERRO_EXCLUSAO.concat(INEXISTENCIA_TRANSFERENCIA));
		}
	}

	@Override
	public List<Transferencia> getTransferencias() {
		return transferenciaRepository.findAll();
	}

	@Override
	public Transferencia getTransferenciaById(Integer transferenciaId) {
		Optional<Transferencia> transferenciaDb = transferenciaRepository.findById(transferenciaId);
		if (transferenciaDb.isPresent()) {
			return transferenciaDb.get();
		} else {
			throw new Exceptions(404, ERRO_PESQUISA.concat(INEXISTENCIA_TRANSFERENCIA));
		}
	}

	public Double getTaxa(LocalDate dataAgenda, LocalDate dataConclusao, Double valor) {
		Double taxa = 0.00;
		// Taxas: A e D
		if ((dataAgenda.equals(dataConclusao)) && (valor <= 1000)) {
			taxa = valor * 3 / 100 + 3;
		} else {
			// Diferença de dias entre as datas
			int dias = Period.between(dataAgenda, dataConclusao).getDays();
			// Taxas: B e D
			if ((dias <= 10) && (valor > 1000 && valor <= 2000)) {
				taxa = valor * 12 / 100;
			} else {
				// Taxas: C e D
				if ((dias > 10) && (valor > 2000)) {
					if (dias <= 20) {
						taxa = valor * 8.2 / 100;
					} else if (dias > 20 && dias <= 30) {
						taxa = valor * 6.9 / 100;
					} else if (dias > 30 && dias <= 40) {
						taxa = valor * 4.7 / 100;
					} else if (dias > 40) {
						taxa = valor * 1.7 / 100;
					}
				}
			}
		}
		return taxa;
	}

	public Boolean verifySaldoSuficiente(Double valor, Double saldo) {
		Boolean result = false;
		if (valor <= saldo) {
			result = true;
		}
		return result;
	}

}