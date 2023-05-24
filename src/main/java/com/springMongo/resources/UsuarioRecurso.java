package com.springMongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springMongo.dominio.Usuario;

@RestController
@RequestMapping(value = "/usuarios") //Caminho do endpoint
public class UsuarioRecurso {

@RequestMapping(method= RequestMethod.GET) //pode ser utlilizado também o método getMapping()

public ResponseEntity<List<Usuario>> findAll(){
	
	Usuario maria = new Usuario("1", "Maria Silva", "maria@gmail.com");
	Usuario alex = new Usuario("2", "Alex Santos", "alex@gmail.com");
	
	List<Usuario> lista = new ArrayList<>();
	lista.addAll(Arrays.asList(maria,alex));
	
	return ResponseEntity.ok().body(lista);
	
}
	
	
}
