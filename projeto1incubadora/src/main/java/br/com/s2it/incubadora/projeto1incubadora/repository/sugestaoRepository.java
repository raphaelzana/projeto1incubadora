package br.com.s2it.incubadora.projeto1incubadora.repository;

import br.com.s2it.incubadora.projeto1incubadora.entity.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sugestaoRepository extends CrudRepository<Sugestao, Long> {

}
