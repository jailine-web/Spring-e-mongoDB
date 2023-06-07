package com.springMongo.DTO;

import java.io.Serializable;
import java.sql.Date;

public class ComentarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String texto;
	private java.util.Date data;
	
	private AutorDTO autor;
	
	public ComentarioDTO() {
		
	}

	public ComentarioDTO(String texto, java.util.Date date, AutorDTO autor) {
		this.texto = texto;
		this.data = date;
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public java.util.Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public AutorDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}
	
}
