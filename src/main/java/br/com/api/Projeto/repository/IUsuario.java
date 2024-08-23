package br.com.api.Projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.Projeto.model.Usuario;

public interface IUsuario extends JpaRepository<Usuario, Integer> {

}
