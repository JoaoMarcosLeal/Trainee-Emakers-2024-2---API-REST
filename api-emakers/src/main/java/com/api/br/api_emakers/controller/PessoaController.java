package com.api.br.api_emakers.controller;

import com.api.br.api_emakers.model.dto.request.LivroRequestDTO;
import com.api.br.api_emakers.model.dto.request.PessoaRequestDTO;
import com.api.br.api_emakers.model.dto.response.PessoaResponseDTO;
import com.api.br.api_emakers.model.entidades.Livro;
import com.api.br.api_emakers.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/all")
    public ResponseEntity<List<PessoaResponseDTO>> getAllPessoas(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getAllPessoas());
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<PessoaResponseDTO> getPessoaById(@PathVariable Integer idPessoa){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getPessoaById(idPessoa));
    }

    @PostMapping("/create")
    public ResponseEntity<PessoaResponseDTO> createPessoa(@Valid @RequestBody PessoaRequestDTO pessoaRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.createPessoa(pessoaRequestDTO));
    }

    @PutMapping("/update/{idPessoa}")
    public ResponseEntity<PessoaResponseDTO> updatePessoa(@Valid @PathVariable Integer idPessoa, @RequestBody PessoaRequestDTO pessoaRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.updatePessoa(idPessoa, pessoaRequestDTO));
    }

    @PutMapping("/emprestimo/{idPessoa}")
    public ResponseEntity<PessoaResponseDTO> fazerEmprestimo(@PathVariable Integer idPessoa, @RequestBody Integer idLivro){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.fazerEmprestimo(idPessoa, idLivro));
    }

    @DeleteMapping("/delete/{idPessoa}")
    public ResponseEntity<String> deletePessoa(@PathVariable Integer idPessoa){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.deletePessoa(idPessoa));
    }
}
