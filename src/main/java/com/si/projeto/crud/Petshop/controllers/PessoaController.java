package com.si.projeto.crud.Petshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.si.projeto.crud.Petshop.entities.Pessoa;
import com.si.projeto.crud.Petshop.repositories.PessoaRepository;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository; 
	
	@GetMapping(path = "/pessoas")
	@ResponseStatus(value = HttpStatus.FOUND)
	public List<Pessoa> getPessoas() {
		return pessoaRepository.findAll();
	}
	
	@PostMapping(path = "/cadastro")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	
	@DeleteMapping(path = "/cadastro/{idPessoa}")
	@ResponseStatus(value = HttpStatus.OK)
	public void deletarPessoa(@PathVariable Long idPessoa) {
		Pessoa pessoa = pessoaRepository.findById(idPessoa).get();
		pessoaRepository.delete(pessoa);
	}

	
	@PutMapping(path = "/cadastro/{idPessoa}/edit")
	@ResponseStatus(value = HttpStatus.OK)
	public void editarPessoa(@PathVariable Long idPessoa, @RequestBody Pessoa pessoa) {
		Pessoa pessoa02 = pessoaRepository.findById(idPessoa).get();
		pessoa02.setEmail(pessoa.getEmail());
		pessoa02.setNome(pessoa.getNome());

		pessoaRepository.save(pessoa02);

	}
	

}
