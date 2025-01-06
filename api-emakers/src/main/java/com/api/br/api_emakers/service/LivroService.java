package com.api.br.api_emakers.service;

import com.api.br.api_emakers.model.dto.request.LivroRequestDTO;
import com.api.br.api_emakers.model.dto.response.LivroResponseDTO;
import com.api.br.api_emakers.model.entidades.Livro;
import com.api.br.api_emakers.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    // List all books
    public List<LivroResponseDTO> getAllLivros() {
        List<Livro> livros = livroRepository.findAll();

        return livros.stream().map(LivroResponseDTO::new).collect(Collectors.toList());
    }

    // Get a book by ID
    public LivroResponseDTO getLivroById(Integer idLivro) {
        Livro livro = getEntityById(idLivro);

        return new LivroResponseDTO(livro);
    }

    // Create a new book
    public LivroResponseDTO createLivro(LivroRequestDTO livroRequestDTO) {
        Livro livro = new Livro(livroRequestDTO);
        livroRepository.save(livro);

        return new LivroResponseDTO(livro);
    }

    // Update a book by ID
    public LivroResponseDTO updateLivro(Integer idLivro, LivroRequestDTO livroRequestDTO) {
        Livro livro = getEntityById(idLivro);
        livro.setNome(livroRequestDTO.nome());
        livro.setAutor(livroRequestDTO.autor());
        livro.setData_lancamento(livroRequestDTO.data_lancamento());
        livro.setEmprestimos(livroRequestDTO.emprestimos());

        livroRepository.save(livro);

        return new LivroResponseDTO(livro);
    }

    // Delete a book by ID
    public String deleteLivro(Integer idLivro) {
        Livro livro = getEntityById(idLivro);
        livroRepository.delete(livro);

        return "Livro deletado com sucesso!";
    }

    // Helper method to retrieve entity by ID
    private Livro getEntityById(Integer idLivro) {
        return livroRepository.findById(idLivro).orElseThrow(() -> new RuntimeException("Livro não encontrado."));
    }
}
