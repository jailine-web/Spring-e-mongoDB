package com.springMongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springMongo.dominio.Post;

public interface PostRepositorio extends MongoRepository<Post, String>{

}
