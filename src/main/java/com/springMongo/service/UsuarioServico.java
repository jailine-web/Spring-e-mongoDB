package com.springMongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springMongo.dominio.Usuario;
import com.springMongo.excecao.ObjetoNaoEncontradoExcecao;
import com.springMongo.repositories.UsuarioRepositorio;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repo;
	
	public List<Usuario> encontrarTodos(){
		 return repo.findAll();
		 
	}
	
	public Usuario buscarPorId(String id) {
		Optional<Usuario> u = repo.findById(id);
		if(u == null) {
			throw new ObjetoNaoEncontradoExcecao("Objeto não encontrado");
		}
		Usuario u1 = u.get();
		return u1;
	}
	
	public Usuario salvarDados(Usuario u) {
		return repo.save(u);
	}
}
