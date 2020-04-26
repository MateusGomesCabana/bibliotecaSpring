/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bliblioteca.livros.servico;


import br.bliblioteca.livros.exception.LivroNotFoundException;
import br.bliblioteca.livros.model.Livro;
import br.bliblioteca.livros.repository.LivroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus
 */
@Service
public class LivroServices {

    @Autowired
    LivroRepository livroRepository;

    public List<Livro> listarTodosLivros() {
        //retorna todos os livros do banco
        //return livroRepository.findAll();
        return livroRepository.listaLivros();
    }

    public void salvarLivro(Livro livro) {
        livroRepository.save(livro);
    }

    public Livro buscaLivro(Long id) {
        return livroRepository.findById(id).orElseThrow(()->new LivroNotFoundException());
    }
    
    public void excluiLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
