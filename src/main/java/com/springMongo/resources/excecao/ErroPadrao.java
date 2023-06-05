package com.springMongo.resources.excecao;

import java.io.Serializable;

public class ErroPadrao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long momento;
	private Integer estado;
	private String erro;
	private String mensagem;
	private String caminho;
	
	public ErroPadrao() {
		
	}

	public ErroPadrao(Long momento, Integer estado, String erro, String mensagem, String caminho) {
		this.momento = momento;
		this.estado = estado;
		this.erro = erro;
		this.mensagem = mensagem;
		this.caminho = caminho;
	}

	public Long getMomento() {
		return momento;
	}

	public void setMomento(Long momento) {
		this.momento = momento;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	
	
}
