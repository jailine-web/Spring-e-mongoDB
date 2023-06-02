package com.springMongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springMongo.dominio.Usuario;
import com.springMongo.repositories.UsuarioRepositorio;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repo;
	
	public List<Usuario> encontrarTodos(){
		 return repo.findAll();
		 
	}
	
	public Usuario salvarDados(Usuario u) {
		return repo.save(u);
	}
}
