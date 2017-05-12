package br.com.supermercado.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.supermercado.model.Convidado;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {

	List<Convidado> findByNome(String nome);

}
