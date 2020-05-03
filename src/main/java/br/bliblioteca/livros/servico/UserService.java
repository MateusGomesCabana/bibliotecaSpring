package br.bliblioteca.livros.servico;

import br.bliblioteca.livros.model.User;
import java.util.List;


public interface UserService {

    void save(User user);

    User findByUsername(String username);

    List<User> findAll();

}
