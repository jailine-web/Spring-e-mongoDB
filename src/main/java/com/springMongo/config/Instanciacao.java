package com.springMongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springMongo.DTO.AutorDTO;
import com.springMongo.dominio.Post;
import com.springMongo.dominio.Usuario;
import com.springMongo.repositories.PostRepositorio;
import com.springMongo.repositories.UsuarioRepositorio;

@Configuration
public class Instanciacao implements CommandLineRunner{

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private PostRepositorio rp;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usuarioRepositorio.deleteAll();
		rp.deleteAll();
		
		Usuario maria = new Usuario(null,"Maria Clara" ,"mariaClara@gmail.com");
		Usuario alex = new Usuario(null, "Alex Manuel","Amanuel@gmail.com" );
		Usuario bob = new Usuario(null, "Bob Green", "bob@gmail.com");
		
		usuarioRepositorio.saveAll(Arrays.asList(maria, alex, bob));
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou para SP, Abçs", new AutorDTO(maria));
		
		Post p2 = new Post(null, sdf.parse("25/09/2020"), "Bom dia", "Acordei feliz hoje", new AutorDTO(bob));
		
		rp.saveAll(Arrays.asList(p1, p2));
		
		maria.getPosts().addAll(Arrays.asList(p1));
		bob.getPosts().addAll(Arrays.asList(p2));
		
		usuarioRepositorio.save(maria);
		usuarioRepositorio.save(bob);
		
	}

}
