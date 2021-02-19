package com.user.management.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.user.management.entity.UsuarioEntity;
import com.user.management.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:8080")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@GetMapping(value = { "", "/" })
	public String welcome(){
		return "Bem vindo (a) a seção de Usuários";
	}
	
	@GetMapping("/all")
	public Iterable<UsuarioEntity> all(){
		return usuarioRepo.findAll();
	}
	
	@GetMapping("/id/{usuarioId}")
	public ResponseEntity<Optional<UsuarioEntity>> byId(@PathVariable Long usuarioId){
		Optional<UsuarioEntity> res = usuarioRepo.findById(usuarioId);
		return ResponseEntity
				.status(res.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND)
				.body(res);
	}

	@GetMapping("/total")
	public Long total() {
		return usuarioRepo.count();
	}
	
	@PostMapping("/add")
	public Boolean add(@Valid @RequestBody UsuarioEntity usuario) {
		return !(usuarioRepo.save(usuario) == null);
	}
	
	@DeleteMapping("/clear")
	public void clear() {
		usuarioRepo.deleteAll();
	}
	
}
