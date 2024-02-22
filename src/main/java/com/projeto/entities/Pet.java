package com.projeto.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Entity
	@Table (name = "pet")
	public class Pet {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	
	private String documento;
	
	@NotNull
	private String nascimento;
	
	@NotNull
	private String cuidador;

	public Pet(String nome, String nascimento, String cuidador) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.cuidador = cuidador;
	}
	
}
