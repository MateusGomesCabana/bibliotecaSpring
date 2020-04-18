/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bliblioteca.livros.repository;
import br.bliblioteca.livros.model.Livro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Mateus
 */
public interface LivroRepository  extends JpaRepository <Livro, Long>{
    
    @Query(value = " from #{#entityName} l left join fetch l.autor a order by l.quantidadePaginas desc ")
    List<Livro> listaLivros(); //faz o left join e retorna
}
