package com.springMongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springMongo.dominio.Post;

public interface PostRepositorio extends MongoRepository<Post, String>{

	public List<Post> findByTituloContainingIgnoreCase(String texto);
	
}
