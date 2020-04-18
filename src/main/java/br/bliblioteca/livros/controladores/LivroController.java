package br.bliblioteca.livros.controladores;

import br.bliblioteca.livros.model.Autor;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.bliblioteca.livros.model.Livro;
import br.bliblioteca.livros.servico.AutorServices;
import br.bliblioteca.livros.servico.LivroServices;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroServices livroService;

    @Autowired
    AutorServices autorService;

    @GetMapping("/list")
    public ModelAndView livros() {
        ModelAndView modelAndView = new ModelAndView("livros/list");
        List<Livro> listaLivros = livroService.listarTodosLivros();

        modelAndView.addObject("livros", listaLivros);
        return modelAndView;
    }

    @GetMapping("/novo")
    public ModelAndView createForm(@ModelAttribute Livro livro) {
        ModelAndView modelAndView = new ModelAndView("livros/form");
        List<Autor> listaAutores = autorService.listaAutores();
        modelAndView.addObject("listaAutores", listaAutores);
        // modelAndView.addObject("livro", new Livro());
        return modelAndView;
    }

    @PostMapping(value = "/gravar")
    public ModelAndView create(@Valid Livro livro, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<Autor> listaAutores = autorService.listaAutores();
            return new ModelAndView("livros/form", "listaAutores", listaAutores);
        }

        livroService.salvarLivro(livro);
        return new ModelAndView("redirect:/livros/list");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {
        Livro livro = livroService.buscaLivro(id);
        List<Autor> listaAutores = autorService.listaAutores();

        ModelAndView modelAndView = new ModelAndView("livros/form");
        modelAndView.addObject("listaAutores", listaAutores);
        modelAndView.addObject("livro", livro);
        return modelAndView;
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        livroService.excluiLivro(id);
        return new ModelAndView("redirect:/livros/list");
    }

}
