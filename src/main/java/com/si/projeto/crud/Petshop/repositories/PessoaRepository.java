package com.si.projeto.crud.Petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.si.projeto.crud.Petshop.entities.Pessoa;

@RepositoryRestResource(collectionResourceRel = "pessoa", path = "pessoa")
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
