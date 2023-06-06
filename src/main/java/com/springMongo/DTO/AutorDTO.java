package com.springMongo.DTO;

import java.io.Serializable;

import com.springMongo.dominio.Usuario;

public class AutorDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	
	public AutorDTO() {
		
	}

	public AutorDTO(Usuario u) {
		id = u.getId();
		nome = u.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
