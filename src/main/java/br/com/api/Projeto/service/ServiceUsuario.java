package br.com.api.Projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.api.Projeto.model.Usuario;
import br.com.api.Projeto.repository.IUsuario;

@Service
public class ServiceUsuario {
	
	private IUsuario repository;
	
	public ServiceUsuario(IUsuario repository) {
		this.repository = repository;
	}
	
	public List<Usuario> listarUsuario() {
		List<Usuario> lista = repository.findAll();
		return lista;
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		Usuario usuarioNovo = repository.save(usuario);
		return usuarioNovo;
	}

}
