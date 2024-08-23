package br.com.api.Projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.Projeto.model.Usuario;
import br.com.api.Projeto.repository.IUsuario;
import br.com.api.Projeto.service.ServiceUsuario;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class ControllerUsuario {
	
	@Autowired
	private IUsuario dao;
	
	private ServiceUsuario serviceUsuario;
	
	public ControllerUsuario(ServiceUsuario serviceUsuario) {
		this.serviceUsuario = serviceUsuario;
	}
	
    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuario() {
    	List<Usuario> lista = serviceUsuario.listarUsuario();
    	return ResponseEntity.status(200).body(lista);
    }

	@PostMapping
	public ResponseEntity<Usuario> criarUsuario (@RequestBody Usuario usuario) {
		return ResponseEntity.status(201).body(serviceUsuario.criarUsuario(usuario));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> editarUsuario (@RequestBody Usuario usuario) {
		Usuario usuarioNovo = dao.save(usuario);
		return ResponseEntity.status(201).body(usuarioNovo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  execluirUsuario (@PathVariable Integer id) {
		dao.deleteById(id);
		return ResponseEntity.status(204).build();
	}
 
}

