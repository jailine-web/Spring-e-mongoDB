package com.springMongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springMongo.dominio.Post;
import com.springMongo.excecao.ObjetoNaoEncontradoExcecao;
import com.springMongo.repositories.PostRepositorio;

@Service
public class PostServico {

	@Autowired
	private PostRepositorio repo;
	
	
	public Post buscarPorId(String id) {
		
		Optional<Post> u = repo.findById(id);
		
		if(u == null) {
			throw new ObjetoNaoEncontradoExcecao("Objeto não encontrado");
		}
		Post u1 = u.get();
		return u1;
	}
	
	public List<Post> buscandoPorTitulo(String texto){
		return repo.findByTituloContainingIgnoreCase(texto);
	}
	
	public List<Post> buscandoTitulos(String texto){
		return repo.pesquisarTitulos(texto);
	}
	
	public List<Post> pesquisaCompleta(String texto, java.util.Date dataMin, java.util.Date dataMax){
		dataMax = new java.util.Date(dataMax.getTime() + 24 * 60 * 1000); 
		return repo.pesquisaCompleta(texto, dataMin, dataMax);
	}
	
}
