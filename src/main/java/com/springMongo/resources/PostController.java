package com.springMongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springMongo.dominio.Post;
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

}
