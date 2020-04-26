/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bliblioteca.livros.servico;

import br.bliblioteca.livros.dto.AvaliacaoDTO;
import br.bliblioteca.livros.model.Avaliacao;
import br.bliblioteca.livros.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus
 */
@Service
public class AvaliacaoService {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    public Long salvaAvaliacao(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao).getId();
    }
}
