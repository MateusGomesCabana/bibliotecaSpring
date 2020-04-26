/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bliblioteca.livros.api;

import static br.bliblioteca.livros.conversor.LivroConverter.toDTO;
import br.bliblioteca.livros.dto.AvaliacaoDTO;
import br.bliblioteca.livros.dto.LivroDTO;
import br.bliblioteca.livros.exception.LivroNotFoundException;
import br.bliblioteca.livros.facade.ApiFacade;
import br.bliblioteca.livros.model.Livro;
import br.bliblioteca.livros.servico.AvaliacaoService;
import br.bliblioteca.livros.servico.LivroServices;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mateus
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    ApiFacade apiController;

    @GetMapping("/livros/list")
    public ResponseEntity<List<LivroDTO>> livros() {
        List<Livro> listaLivros = apiController.listaTodosLivros();
        return ResponseEntity.ok(toDTO(listaLivros));
    }

    @PostMapping("/livro/avaliacao/{id}")
    public ResponseEntity<Long> comentario(@PathVariable("id") Long id, @Valid @RequestBody AvaliacaoDTO avaliacaoDTO) {
        System.out.println("asda");
        try {
            return ResponseEntity.ok(apiController.salvarAvaliacao(id, avaliacaoDTO));
        } catch (LivroNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
