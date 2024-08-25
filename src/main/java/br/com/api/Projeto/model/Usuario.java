
package br.com.api.Projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "usuario")

// Criação do Objeto usuario (Class), aos quais seram entidades 
public class Usuario {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotBlank(message = "O nome é Obrigatório!")
	@Size(min = 3, message = "O nome deve ter mais que 3 letras!")
	@Column(name = "nome_completo", length = 200, nullable = false )	 
	private String nome;
	
	@Email(message = "Insira um Email válido!")
	@NotBlank(message = "O email é Obrigatorio!")
	@Column(name = "email", length = 50, nullable = false )	 
	private String email;
	
	@NotBlank(message = "A senha é Obrigatorio!")
	@Column(name = "senha", columnDefinition = "TEXT", nullable = false )	 
	private String senha;
	
	@NotBlank(message = "O celular é Obrigatorio!")
	@Column(name = "celular", length = 15, nullable = false )	 
	private String celular;

	// Getters e Setters para acessar e modificar os campos privados da classe
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
}
