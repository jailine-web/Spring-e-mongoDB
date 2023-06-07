package com.springMongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springMongo.dominio.Post;
import com.springMongo.resources.util.URL;
import com.springMongo.service.PostServico;

@RestController
@RequestMapping(value ="/posts") //Caminho do endpoint
public class PostController {

	@Autowired
	private PostServico servico;
	

@RequestMapping(value="/{id}", method=RequestMethod.GET)
public ResponseEntity<Post> encontrarPorId(@PathVariable String id){
	
	Post post = servico.buscarPorId(id);
	
	return ResponseEntity.ok().body(post);
	
}

@RequestMapping(value="/buscartitulo", method=RequestMethod.GET)
public ResponseEntity<List<Post>> buscarTitulo(@RequestParam(value="texto", defaultValue = "") String texto){
	
	texto = URL.decodificador(texto); // decodifica o texto recebido
	List<Post> lista = servico.buscandoTitulos(texto);
		
	return ResponseEntity.ok().body(lista);
	
}

}
