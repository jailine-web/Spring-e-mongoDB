package com.springMongo.excecao;

public class ObjetoNaoEncontradoExcecao extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjetoNaoEncontradoExcecao(String msg) {
		super(msg);
	}
	

}
