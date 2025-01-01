package com.api.br.api_emakers.repository;

import com.api.br.api_emakers.model.entidades.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
}
