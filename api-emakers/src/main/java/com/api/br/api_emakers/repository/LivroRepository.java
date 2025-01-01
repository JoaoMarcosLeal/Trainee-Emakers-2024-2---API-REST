package com.api.br.api_emakers.repository;

import com.api.br.api_emakers.model.entidades.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
