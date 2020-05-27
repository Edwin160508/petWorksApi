package br.com.petworks.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petworks.domain.entity.Teste;
import br.com.petworks.domain.repository.TesteRepository;
import br.com.petworks.rest.model.TesteEntrada;
import br.com.petworks.rest.model.TesteSaida;

@Service
public class TesteService {

	@Autowired
	private TesteRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<TesteSaida> listarTodos(){
		List<Teste> entityList = repository.findAll();
		List<TesteSaida> modelList = new ArrayList<>();
		
		for(Teste entity :entityList) {
			modelList.add(converteParaModelo(entity));
		}
		
		return modelList;
	}
	
	public TesteSaida salvar(TesteEntrada entrada) {
		Teste testeSalvo = repository.save(converteParaEntidade(entrada));
		return converteParaModelo(testeSalvo);
		
	}
	
	public TesteSaida alterar(Long id, TesteEntrada entrada) {
		Optional<Teste> testeEncontrado = buscaPorId(id);
		testeEncontrado.map(teste->{
			teste.setNome(entrada.getNome());
			return repository.save(teste);
		});
		return converteParaModelo(testeEncontrado.get());
	}
	
	public TesteSaida buscaTestePeloId(Long id) {
		Teste testeEncontrado = buscaPorId(id).get();
		return converteParaModelo(testeEncontrado);
	}
	
	public void remover(Long id) {
		Optional<Teste> testeEncontrado = buscaPorId(id);
		repository.delete(testeEncontrado.get());
	}
	
	private Optional<Teste> buscaPorId(Long id){
		return repository.findById(id);
	}
	
	private TesteSaida converteParaModelo(Teste entity) {
		return modelMapper.map(entity, TesteSaida.class);
	}
	
	private Teste converteParaEntidade(TesteEntrada entrada) {
		return modelMapper.map(entrada, Teste.class);
	}
}
