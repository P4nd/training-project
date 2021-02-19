package com.user.management.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import com.user.management.entity.CargoEntity;
import org.springframework.http.ResponseEntity;
import com.user.management.repository.CargoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargo")
@CrossOrigin(origins = "http://localhost:8080")
public class CargoController {
	
	@Autowired
	private CargoRepository cargoRepo;
	
	@GetMapping(value = { "", "/" })
	public String welcome(){
		return "Bem vindo (a) a seção de Cargos";
	}
	
	@GetMapping("/all")
	public Iterable<CargoEntity> all(){
		return cargoRepo.findAll();
	}
	
	@GetMapping("/id/{cargoId}")
	public ResponseEntity<Optional<CargoEntity>> byId(@PathVariable Long cargoId){
		Optional<CargoEntity> res = cargoRepo.findById(cargoId);
		return ResponseEntity
				.status(res.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND)
				.body(res);
	}

	@GetMapping("/total")
	public Long total() {
		return cargoRepo.count();
	}
	
	@PostMapping("/add")
	public Boolean add(@Valid @RequestBody CargoEntity cargo) {
		return !(cargoRepo.save(cargo) == null);
	}
	
	@DeleteMapping("/clear")
	public void clear() {
		cargoRepo.deleteAll();
	}
	
}
