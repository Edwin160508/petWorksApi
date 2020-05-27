package br.com.petworks.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.petworks.domain.service.TesteService;
import br.com.petworks.rest.model.TesteEntrada;
import br.com.petworks.rest.model.TesteSaida;

@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	private TesteService service;
	
	@GetMapping
	public ResponseEntity<List<TesteSaida>> listarTodos(){
		return ResponseEntity.ok(service.listarTodos());
	}
	
	@PostMapping
	public ResponseEntity<TesteSaida> salvar(@Valid @RequestBody TesteEntrada entrada){
		return ResponseEntity.ok(service.salvar(entrada));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TesteSaida> buscarPeloId(@PathVariable Long id){
		return ResponseEntity.ok(service.buscaTestePeloId(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		service.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TesteSaida> atualizar(Long id, TesteEntrada entrada){
		return ResponseEntity.ok(service.alterar(id, entrada));
	}
}
