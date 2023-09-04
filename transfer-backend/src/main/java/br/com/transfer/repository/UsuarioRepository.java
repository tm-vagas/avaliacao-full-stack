package br.com.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.transfer.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}