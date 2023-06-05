package com.springMongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springMongo.DTO.UsuarioDTO;
import com.springMongo.dominio.Usuario;
import com.springMongo.service.UsuarioServico;

@RestController
@RequestMapping(value ="/usuarios") //Caminho do endpoint
public class UsuarioController {

	@Autowired
	private UsuarioServico servico;
	
@RequestMapping(method=RequestMethod.GET)
public ResponseEntity<List<UsuarioDTO>> encontrarTodosUsuarios(){
	
	List<Usuario> lista = servico.encontrarTodos();
	List<UsuarioDTO> listaDTO = lista.stream().
			map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
	return ResponseEntity.ok().body(listaDTO);
	
}

@RequestMapping(value="/{id}",method=RequestMethod.GET)
public ResponseEntity<UsuarioDTO> encontrarPorId(@PathVariable String id){
	Usuario usuario = servico.buscarPorId(id);
	
	return ResponseEntity.ok().body(new UsuarioDTO(usuario));
	
}

@RequestMapping(method=RequestMethod.POST)
public ResponseEntity<Void> inserir(@RequestBody UsuarioDTO usuarioDto ){
	Usuario usuario = servico.usuarioDto(usuarioDto);
	usuario = servico.inserir(usuario);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(usuario.getId()).toUri();
	
	return ResponseEntity.created(uri).build();
}	
	
@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
public ResponseEntity<Void> excluir(@PathVariable String id){
	servico.excluir(id);
	
	return ResponseEntity.noContent().build();
	
}

}
