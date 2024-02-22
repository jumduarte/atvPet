package com.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projeto.DTO.PetDTO;
import com.projeto.entities.Pet;
import com.projeto.repository.PetRepository;

@Service
public class PetService {
	private final PetRepository petRepository;
	
	@AutoWired
	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	public petDTO salvar(PetDTO petDTO) {
		Pet pet = new Pet(null, petDTO.nome(), petDTO.cuidador(),petDTO.documento(),petDTO.nascimento());
		Pet salvarPet = petRepository.save(pet);
		return new PetDTO(salvarPet.getId(),salvarPet.getNome(),salvarPet.getCuidador(),salvarPet.getNascimento());
	}
	public PetDTO atualizar(Long id, PetDTO petDTO) {
		Pet existePet = petRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
		existePet.setNome(petDTO.nome());
		existePet.setCuidador(petDTO.cuidador());
		existePet.setDocumento(petDTO.documento());
		existePet.setNascimento(petDTO.nascimento());
		
		Pet updatePet = petRepository.save(existePet);
		return new Pet(updatePet.getId(),updatePet.getNome(),updatePet.getCuidador(),updatePet.getDocumento(),updatePet.getNascimento());
	}
	
	public boolean deletePet(Long id) {
		Optional<Pet> existingPet = petRepository.findById(id);
		if (existingPet.isPresent()) {
			petRepository.deleteById(id);
			return true;
		}
		return false;
	}
	public List<Pet> buscarTodos(){
		return petRepository.findAll();
	}
	public Pet buscarPorId(Long id) {
		Optional <Pet> pet = petRepository.findById(id);
		return pet.orElse(null);
	}
	

}
