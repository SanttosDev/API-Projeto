package br.com.api.Projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.Projeto.model.Usuario;

// Permite interagir com banco de dados, através da interface "JpaRepository"
public interface IUsuario extends JpaRepository<Usuario, Integer> {

}
