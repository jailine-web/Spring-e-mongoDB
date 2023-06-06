package com.springMongo.dominio;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.springMongo.DTO.AutorDTO;

@Document
public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private java.util.Date data;
	private String titulo;
	private String conteudo;
	
	private AutorDTO autorDTO;
	
	public Post() {
		
	}

	public Post(String id, java.util.Date data, String titulo, String conteudo, AutorDTO autorDTO) {
		this.id = id;
		this.data = data;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.autorDTO = autorDTO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public java.util.Date getData() {
		return data;
	}

	public void setData(java.util.Date data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public AutorDTO getAutor() {
		return autorDTO;
	}

	public void setAutor(AutorDTO autorDTO) {
		this.autorDTO = autorDTO;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
