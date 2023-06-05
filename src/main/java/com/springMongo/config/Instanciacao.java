package com.springMongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springMongo.dominio.Usuario;
import com.springMongo.repositories.UsuarioRepositorio;

@Configuration
public class Instanciacao implements CommandLineRunner{

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Override
	public void run(String... args) throws Exception {
		
		usuarioRepositorio.deleteAll();
		
		Usuario maria = new Usuario(null,"Maria Clara" ,"mariaClara@gmail.com");
		Usuario alex = new Usuario(null, "Alex Manuel","Amanuel@gmail.com" );
		Usuario bob = new Usuario(null, "Bob Green", "bob@gmail.com");
		usuarioRepositorio.saveAll(Arrays.asList(maria, alex, bob));
	}

}
