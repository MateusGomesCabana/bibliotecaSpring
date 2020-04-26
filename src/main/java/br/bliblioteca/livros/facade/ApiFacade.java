/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bliblioteca.livros.facade;

import br.bliblioteca.livros.conversor.AvaliacaoConverter;
import br.bliblioteca.livros.dto.AvaliacaoDTO;
import br.bliblioteca.livros.model.Avaliacao;
import br.bliblioteca.livros.model.Livro;
import br.bliblioteca.livros.servico.AvaliacaoService;
import br.bliblioteca.livros.servico.LivroServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus
 */
@Service
public class ApiFacade {

    @Autowired
    LivroServices livroService;

    @Autowired
    AvaliacaoService avaliacaoService;

    public List<Livro> listaTodosLivros() {
        return livroService.listarTodosLivros();
    }

    public Long salvarAvaliacao(Long idLivro, AvaliacaoDTO avaliacaoDTO) {
        Livro livro = livroService.buscaLivro(idLivro);
        Avaliacao avaliacao = AvaliacaoConverter.toModel(avaliacaoDTO, livro);
        return avaliacaoService.salvaAvaliacao(avaliacao);

    }
}
