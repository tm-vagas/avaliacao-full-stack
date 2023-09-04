package br.com.transfer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transfer.entity.Usuario;
import br.com.transfer.repository.UsuarioRepository;
import br.com.transfer.service.exception.Exceptions;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	
    static final String ERRO_EDICAO = "Não foi possível realizar a edição!";
    static final String ERRO_EXCLUSAO = "Não foi possível realizar a exclusão!";
    static final String ERRO_PESQUISA = "Não foi possível realizar a pesquisa!";
    static final String INEXISTENCIA_USUARIO = " Usuário inexistente.";
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario createUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario updateUsuario(Integer usuarioId, Usuario usuario) {
		Optional<Usuario> usuarioDb = usuarioRepository.findById(usuarioId);
		if(usuarioDb.isPresent()) {
			Usuario usuarioUpdate = usuarioDb.get();
            usuarioUpdate.setId(usuario.getId());
            usuarioUpdate.setNome(usuario.getNome());
            usuarioUpdate.setContasBancarias(usuario.getContasBancarias());
            usuarioRepository.save(usuarioUpdate);
            return usuarioUpdate;			
		} else {
			throw new Exceptions(404, ERRO_EDICAO.concat(INEXISTENCIA_USUARIO));			
		}
	}

	@Override
	public void deleteUsuario(Integer usuarioId) {
		Optional<Usuario> usuarioDb = usuarioRepository.findById(usuarioId);
        if (usuarioDb.isPresent()) {
            usuarioRepository.delete(usuarioDb.get());
        } else {
        	throw new Exceptions(404, ERRO_EXCLUSAO.concat(INEXISTENCIA_USUARIO));
        }		
	}

	@Override
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario getUsuarioBydId(Integer usuarioId) {
		Optional<Usuario> usuarioDb = usuarioRepository.findById(usuarioId);
        if (usuarioDb.isPresent()) {
            return usuarioDb.get();
        } else {
        	throw new Exceptions(404, ERRO_PESQUISA.concat(INEXISTENCIA_USUARIO));
        }
	}

}