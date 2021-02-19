package com.user.management.entity;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Usuario")
public class UsuarioEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
		
	@Column(name = "nome")
	public String nome;
	
	@Column(name = "cpf")
	@Length(min = 1, max = 12, message = "CPF precisa ter ao menos 12 números")
	public String cpf;
	
	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	public Date dataNascimento;
	
	@Column(name = "sexo")
	@Length(min = 1, max = 1, message = "Apenas 'f' ou 'm' em sexo")
	public String sexo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_cargo_id")
	private CargoEntity cargo;

	// =========================================================
	// =========================================================
	// =========================================================
	// =========================================================
	
	public UsuarioEntity() {}
	
	public UsuarioEntity(
			long id,
			String nome,
			@Length(min = 1, max = 12, message = "CPF precisa ter ao menos 12 números") String cpf,
			@Length(min = 1, max = 1, message = "Apenas 'f' ou 'm' em sexo") String sexo,
			Date dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cargo = null;
	}
	
	public UsuarioEntity(
			long id,
			String nome,
			@Length(min = 1, max = 12, message = "CPF precisa ter ao menos 12 números") String cpf,
			Date dataNascimento,
			CargoEntity cargo,
			@Length(min = 1, max = 1, message = "Apenas 'f' ou 'm' em sexo") String sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cargo = cargo;
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

	public String getCpf() {
		return cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public CargoEntity getCargo() {
		return cargo;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setCargo(CargoEntity cargo) {
		this.cargo = cargo;
	}

}
