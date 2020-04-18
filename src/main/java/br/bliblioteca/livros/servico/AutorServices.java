/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bliblioteca.livros.servico;

import br.bliblioteca.livros.model.Autor;
import br.bliblioteca.livros.model.Livro;
import br.bliblioteca.livros.repository.AutorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Mateus
 */
@Service
public class AutorServices {
     @Autowired
    AutorRepository autorRepository;
    public List<Autor> listaAutores(){
        //retorna todos os livros do banco
        //return livroRepository.findAll();
        return autorRepository.findAll();
    }
}
