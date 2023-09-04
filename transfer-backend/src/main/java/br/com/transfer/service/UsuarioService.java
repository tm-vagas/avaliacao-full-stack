package br.com.transfer.service;

import java.util.List;

import br.com.transfer.entity.Usuario;

public interface UsuarioService {
	
	Usuario createUsuario(Usuario usuario);

    Usuario updateUsuario(Integer usuarioId, Usuario usuario);

    void deleteUsuario(Integer usuarioId);

    List<Usuario> getUsuarios();

    Usuario getUsuarioBydId(Integer usuarioId);

}