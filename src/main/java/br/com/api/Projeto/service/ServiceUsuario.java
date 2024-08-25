package br.com.api.Projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.api.Projeto.model.Usuario;
import br.com.api.Projeto.repository.IUsuario;

@Service 
public class ServiceUsuario {
	
	private IUsuario repository; // Repositório que interage com banco de dados
	private PasswordEncoder passwordEncoder;
	
	// Construtor para as dependências necessarias
	public ServiceUsuario(IUsuario repository) {
		this.repository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	// Lista com todos usarios do banco de dados
	public List<Usuario> listarUsuario() {
		List<Usuario> lista = repository.findAll();
		return lista;
	}
	
	// Cria um novo usuário no banco de dados, escondendo a senha antes de salvar
	public Usuario criarUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		Usuario usuarioNovo = repository.save(usuario);
		return usuarioNovo;
	}
	
	// Edita um usuário existente
	public Usuario editarUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		Usuario usuarioNovo = repository.save(usuario);
		return usuarioNovo;
	}
	
	// Exclui um um usuario através do id
	public Boolean excluirUsuario(Integer id) {
		repository.deleteById(id);
		return true;
	}

	// Valida a senha do usuario
	public Boolean validarSenha(Usuario usuario) {
	    Optional<Usuario> optionalUsuarioBD = repository.findById(usuario.getId());
	    if (optionalUsuarioBD.isPresent()) {
	        Usuario usuarioBD = optionalUsuarioBD.get();
	        String senha = usuarioBD.getSenha();
	        Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
	        return valid; 
	    }
	    return false;
	}

}