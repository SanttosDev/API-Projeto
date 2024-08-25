package br.com.api.Projeto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.api.Projeto.model.Usuario;
import br.com.api.Projeto.service.ServiceUsuario;
import jakarta.validation.Valid;

@RestController 
@CrossOrigin("*") 
@RequestMapping("/usuarios")
public class ControllerUsuario {
    
    private final ServiceUsuario serviceUsuario;
    
    // Contrutor para as dependecias necessarias 
    public ControllerUsuario(ServiceUsuario serviceUsuario) {
        this.serviceUsuario = serviceUsuario;
    }
    
    // Requisição Get para lista de usarios
    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuario() {
        List<Usuario> lista = serviceUsuario.listarUsuario();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    // Requisição Post para criar novo usuario
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioCriado = serviceUsuario.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
    }
    
    // Requisição Put para editar usuario existente 
    @PutMapping
    public ResponseEntity<Usuario> editarUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioEditado = serviceUsuario.editarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioEditado);
    }
    
    // Requisição Delete para excluir usuario através do id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable("id") Integer id) {
        serviceUsuario.excluirUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Requisição Post para validar senha 
    @PostMapping("/login")
    public ResponseEntity<Void> validarSenha(@Valid @RequestBody Usuario usuario) {
        Boolean valid = serviceUsuario.validarSenha(usuario);
        if (!valid) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Trata exceções de validções 
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
    	Map<String, String> errors = new HashMap<>();
    		
    	ex.getBindingResult().getAllErrors().forEach((error) -> {
    		String fieldName = ((FieldError) error).getField();
    		String errorMessage = error.getDefaultMessage();
    		errors.put(fieldName, errorMessage);
    			
    	});
    	return errors;
    }
}
