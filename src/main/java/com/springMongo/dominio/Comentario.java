package com.springMongo.dominio;

import java.time.Instant;

public class Comentario {

	private String texto;
	private Instant data;
	
	private Usuario usuario;
	
	public Comentario() {
		
	}

	public Comentario(String texto, Instant data, Usuario usuario) {
		this.texto = texto;
		this.data = data;
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
