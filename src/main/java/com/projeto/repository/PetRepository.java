package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

}
