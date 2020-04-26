/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bliblioteca.livros.repository;

import br.bliblioteca.livros.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mateus
 */
public interface AvaliacaoRepository extends JpaRepository <Avaliacao, Long>{
    
}
