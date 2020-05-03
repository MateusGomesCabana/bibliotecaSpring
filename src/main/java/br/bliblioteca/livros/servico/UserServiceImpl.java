package br.bliblioteca.livros.servico;

import br.bliblioteca.livros.model.Role;
import br.bliblioteca.livros.model.User;
import br.bliblioteca.livros.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.getRoles().add(new Role("ROLE_BASIC"));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {

        return userRepository.findByUsername(username);

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findBasic() {
        List<User> user = userRepository.findAll();
        List<User> userFinal = new ArrayList<>();
        for (int i = 0; i < user.size(); i++) {
            for (int j = 0; j < user.get(i).getRoles().size(); j++) {
                if (user.get(i).getRoles().get(j).getRole() == "ROLE_BASIC") {
                     userFinal.add(user.get(i));
                     break;
                }
            }

        }
        return userFinal;
    }
}
