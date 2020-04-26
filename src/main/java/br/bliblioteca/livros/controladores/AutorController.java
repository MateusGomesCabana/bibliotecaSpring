/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bliblioteca.livros.controladores;

import br.bliblioteca.livros.model.Autor;
import br.bliblioteca.livros.servico.AutorServices;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mateus
 */
@Controller
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    AutorServices autorService;
    
    @GetMapping("/list")
    public ModelAndView livros() {
        ModelAndView modelAndView = new ModelAndView("autor/list");
        List<Autor> listaAutor = autorService.listaAutores();
        modelAndView.addObject("autores", listaAutor);
        return modelAndView;
    }

    @GetMapping("/novo")
    public ModelAndView createForm(@ModelAttribute Autor autor) {
        ModelAndView modelAndView = new ModelAndView("autor/form");
        List<Autor> listaAutores = autorService.listaAutores();
        modelAndView.addObject("listaAutores", listaAutores);
        // modelAndView.addObject("livro", new Livro());
        return modelAndView;
    }

    @PostMapping(value = "/gravar")
    public ModelAndView create(@Valid Autor autor, BindingResult bindingResult) {
          if (bindingResult.hasErrors()) {
            List<Autor> listaAutores = autorService.listaAutores();
            return new ModelAndView("autor/form", "listaAutores", listaAutores);
        }
//
        autorService.salvarAutor(autor);
        return new ModelAndView("redirect:/autor/list");
  
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {
        Autor autor = autorService.buscaAutor(id);
        List<Autor> listaAutores = autorService.listaAutores();
        
        ModelAndView modelAndView = new ModelAndView("autor/form");
         modelAndView.addObject("listaAutores", listaAutores);
        modelAndView.addObject("autor", autor);
        return modelAndView;
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
      
        autorService.excluiAutor(id);
        return new ModelAndView("redirect:/autor/list");
    }

}
