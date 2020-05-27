package br.com.petworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.petworks.domain.entity.Teste;

@Repository
public interface TesteRepository extends JpaRepository<Teste, Long>{

}
