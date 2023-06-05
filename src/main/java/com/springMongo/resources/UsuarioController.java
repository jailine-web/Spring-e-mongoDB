package com.springMongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	//Usuario maria = new Usuario("1", "Maria Silva", "maria@gmail.com");
	//Usuario alex = new Usuario("2", "Alex Santos", "alex@gmail.com");
	
	//servico.salvarDados(maria);
	
	List<Usuario> lista = servico.encontrarTodos();
	List<UsuarioDTO> listaDTO = lista.stream().
			map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
	return ResponseEntity.ok().body(listaDTO);
	
}
@PostMapping
public Usuario salvarUsuario(@RequestBody Usuario u) {
	return servico.salvarDados(u);
}
	
	
}
