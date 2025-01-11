package com.api.br.api_emakers.service;

import com.api.br.api_emakers.model.dto.request.PessoaRequestDTO;
import com.api.br.api_emakers.model.dto.response.PessoaResponseDTO;
import com.api.br.api_emakers.model.entidades.Livro;
import com.api.br.api_emakers.model.entidades.Pessoa;
import com.api.br.api_emakers.repository.LivroRepository;
import com.api.br.api_emakers.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public List<PessoaResponseDTO> getAllPessoas(){
        List<Pessoa> pessoas = pessoaRepository.findAll();

        return pessoas.stream().map(PessoaResponseDTO::new).collect(Collectors.toList());
    }

    public PessoaResponseDTO getPessoaById(Integer idPessoa){
        Pessoa pessoa = getEntityById(idPessoa);

        return new PessoaResponseDTO(pessoa);
    }

    public PessoaResponseDTO createPessoa(PessoaRequestDTO pessoaRequestDTO){
        Pessoa pessoa = new Pessoa(pessoaRequestDTO);
        pessoaRepository.save(pessoa);

        return new PessoaResponseDTO(pessoa);
    }

    public PessoaResponseDTO updatePessoa(Integer idPessoa, PessoaRequestDTO pessoaRequestDTO){
        Pessoa pessoa = getEntityById(idPessoa);
        pessoa.setNome(pessoaRequestDTO.nome());
        pessoa.setCep(pessoaRequestDTO.cep());

        pessoaRepository.save(pessoa);

        return new PessoaResponseDTO(pessoa);
    }

    public String deletePessoa(Integer idPessoa){
        Pessoa pessoa = getEntityById(idPessoa);
        pessoaRepository.delete(pessoa);

        return "Pessoa deletada com sucesso!";
    }

    public PessoaResponseDTO fazerEmprestimo(Integer idPessoa, Integer idLivro){
        Livro livro = livroRepository.getReferenceById(idLivro);
        Pessoa pessoa = getEntityById(idPessoa);
        pessoa.addEmprestimo(livro);
        pessoaRepository.save(pessoa);

        return new PessoaResponseDTO(pessoa);
    }

    private Pessoa getEntityById(Integer idPessoa){
        return pessoaRepository.findById(idPessoa).orElseThrow(()-> new RuntimeException("Pessoa não encontrada."));
    }

}
