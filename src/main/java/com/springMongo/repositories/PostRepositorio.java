package com.springMongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springMongo.dominio.Post;

public interface PostRepositorio extends MongoRepository<Post, String>{

	
	@Query("{ 'titulo': { $regex: ?0, $options: 'i'} }")
	List<Post> pesquisarTitulos(String texto);
	
	public List<Post> findByTituloContainingIgnoreCase(String texto);
	
	@Query("{ $and: [ { data: {$gte: ?1 } }, { data: { $lte: ?2 } } , { $or: [ { 'titulo': { $regex: ?0, $options: 'i' } }, { 'conteudo': { $regex: ?0, $options: 'i' } }, { 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	
	public List<Post> pesquisaCompleta(String text, java.util.Date dataMin, java.util.Date dataMax);
	
}
