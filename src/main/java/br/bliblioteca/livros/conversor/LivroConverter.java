/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bliblioteca.livros.conversor;

import br.bliblioteca.livros.dto.LivroDTO;
import br.bliblioteca.livros.model.Livro;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Mateus
 */
public class LivroConverter {

    public static LivroDTO toDTO(Livro livro) {
        LivroDTO dto = new LivroDTO();
        dto.setTitulo(livro.getNome());
        dto.setPaginas(livro.getQuantidadePaginas());
        dto.setAutor(livro.getAutor() != null ? livro.getAutor().getNome() : "");
        dto.setAvaliacoes(livro.getAvaliacoes().size() > 0 ? AvaliacaoConverter.toDTO(livro.getAvaliacoes()) : Arrays.asList());
        return dto;
    }

    public static List<LivroDTO> toDTO(List<Livro> livros) {
        return livros.stream().map(l -> toDTO(l)).collect(Collectors.toList());
    }
}
