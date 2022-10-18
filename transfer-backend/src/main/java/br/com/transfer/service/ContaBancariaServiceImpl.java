package br.com.transfer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transfer.entity.ContaBancaria;
import br.com.transfer.entity.Usuario;
import br.com.transfer.repository.ContaBancariaRepository;
import br.com.transfer.repository.UsuarioRepository;
import br.com.transfer.service.exception.Exceptions;

@Service
@Transactional
public class ContaBancariaServiceImpl implements ContaBancariaService {
	
	static final String ERRO_CADASTRO = "Não foi possível realizar o cadastro!";
	static final String ERRO_EDICAO = "Não foi possível realizar a edição!";
    static final String ERRO_EXCLUSAO = "Não foi possível realizar a exclusão!";
    static final String ERRO_PESQUISA = "Não foi possível realizar a pesquisa!";
    static final String INEXISTENCIA_CONTA_BANCARIA = " Conta Bancária inexistente.";
    static final String INEXISTENCIA_USUARIO = " Usuário inexistente.";
	
	@Autowired
	private ContaBancariaRepository contaBancariaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public ContaBancaria createContaBancaria(Integer usuarioId, ContaBancaria contaBancaria) {		
		Optional<Usuario> usuarioDb = usuarioRepository.findById(usuarioId);
		if(usuarioDb.isPresent()) {
			contaBancariaRepository.save(contaBancaria);
			List<ContaBancaria> contasBancarias = new ArrayList<>();
			contasBancarias.add(contaBancaria);	
			Usuario usuarioUpdate = usuarioDb.get();			
			usuarioUpdate.setContasBancarias(contasBancarias);
			usuarioRepository.save(usuarioUpdate);
			return contaBancaria;
		} else {
			throw new Exceptions(404, ERRO_CADASTRO.concat(INEXISTENCIA_USUARIO));
		}
	}

	@Override
	public ContaBancaria updateContaBancaria(Integer contaBancariaId, ContaBancaria contaBancaria) {
		Optional<ContaBancaria> contaBancariaDb = contaBancariaRepository.findById(contaBancariaId);
        if (contaBancariaDb.isPresent()) {
            ContaBancaria contaBancariaUpdate = contaBancariaDb.get();
            contaBancariaUpdate.setId(contaBancaria.getId());
            contaBancariaUpdate.setSaldo(contaBancaria.getSaldo());
            contaBancariaRepository.save(contaBancariaUpdate);
            return contaBancariaUpdate;
        } else {
        	throw new Exceptions(404, ERRO_EDICAO.concat(INEXISTENCIA_CONTA_BANCARIA));
        }
	}

	@Override
	public void deleteContaBancaria(Integer contaBancariaId) {		
		Optional<ContaBancaria> contaBancariaDb = contaBancariaRepository.findById(contaBancariaId);
        if (contaBancariaDb.isPresent()) {
            contaBancariaRepository.delete(contaBancariaDb.get());
        } else {
        	throw new Exceptions(404, ERRO_EXCLUSAO.concat(INEXISTENCIA_CONTA_BANCARIA));
        }
	}

	@Override
	public List<ContaBancaria> getContasBancarias() {
		return contaBancariaRepository.findAll();
	}

	@Override
	public ContaBancaria getContaBancariaById(Integer contaBancariaId) {
		Optional<ContaBancaria> contaBancariaDb = contaBancariaRepository.findById(contaBancariaId);
        if (contaBancariaDb.isPresent()) {
            return contaBancariaDb.get();
        } else {
        	throw new Exceptions(404, ERRO_PESQUISA.concat(INEXISTENCIA_CONTA_BANCARIA));
        }
	}
	
}