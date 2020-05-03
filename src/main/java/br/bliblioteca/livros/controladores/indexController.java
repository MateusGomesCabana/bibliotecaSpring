/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bliblioteca.livros.controladores;

import br.bliblioteca.livros.model.Autor;
import br.bliblioteca.livros.model.Livro;
import br.bliblioteca.livros.model.User;
import br.bliblioteca.livros.servico.AutorServices;
import br.bliblioteca.livros.servico.LivroServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mateus
 */
@Controller
public class indexController {

    @Autowired
    LivroServices livroService;
    @Autowired
    AutorServices autorService;

    @GetMapping("/")
    public ModelAndView login() {
        return new ModelAndView("login", "userForm", new User());
    }

    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
