package com.springMongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springMongo.dominio.Usuario;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String>{

}
