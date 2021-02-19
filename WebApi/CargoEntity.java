package com.user.management.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Cargo")
public class CargoEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome")
	@NotNull(message = "Nome não pode ser nulo")
	@NotBlank(message = "Nome não pode ser branco")
	private String nome;

	// =========================================================
	// =========================================================
	// =========================================================
	// =========================================================
	
	public CargoEntity() {}
	
	public CargoEntity(
			long id,
			@NotNull(message = "Nome não pode ser nulo") @NotBlank(message = "Nome não pode ser branco") String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	// =========================================================
	// =========================================================
	// =========================================================
	// =========================================================

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
