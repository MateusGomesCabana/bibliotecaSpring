/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bliblioteca.livros.conversor;

import br.bliblioteca.livros.dto.AvaliacaoDTO;
import br.bliblioteca.livros.model.Avaliacao;
import br.bliblioteca.livros.model.Livro;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Mateus
 */
public class AvaliacaoConverter {

    public static AvaliacaoDTO toDTO(Avaliacao avaliacao) {
        AvaliacaoDTO dto = new AvaliacaoDTO();
        dto.setComentario(avaliacao.getComentario());
        dto.setNota(avaliacao.getNota());
        return dto;
    }

    public static Avaliacao toModel(AvaliacaoDTO avaliacaoDTO) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setComentario(avaliacaoDTO.getComentario());
        avaliacao.setNota(avaliacaoDTO.getNota());
        return avaliacao;
    }

    public static Avaliacao toModel(AvaliacaoDTO avaliacaoDTO, Livro livro) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setComentario(avaliacaoDTO.getComentario());
        avaliacao.setNota(avaliacaoDTO.getNota());
        avaliacao.setLivro(livro);
        return avaliacao;
    }

    public static List<AvaliacaoDTO> toDTO(List<Avaliacao> avaliacao) {
        return avaliacao.stream().map(l -> toDTO(l)).collect(Collectors.toList());
    }
}
