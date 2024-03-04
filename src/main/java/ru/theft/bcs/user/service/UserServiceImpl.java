package ru.theft.bcs.user.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.theft.bcs.user.model.User;
import ru.theft.bcs.user.repository.UserRepository;
import ru.theft.bcs.util.exception.BadRequestException;
import ru.theft.bcs.util.exception.NotFoundException;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        log.info("Quantity users: {}", userRepository.findAll().size());
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        log.info("User got by {} id.", id);
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User has no found by " + id + " id."));
    }

    @Override
    public User add(User user) {

        if (user.getLogin().isEmpty() || user.getLogin().isBlank()) {
            throw new BadRequestException("Login can't be empty or blank.");
        }

        if (user.getPassword().isBlank() || user.getPassword().isEmpty()) {
            throw new BadRequestException("Password can't be empty or blank.");
        }

        if (user.getPassword().equals(user.getLogin())) {
            throw new BadRequestException("The password and login can't be equal.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        log.info("{} was created successfully.", user);
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(getById(user.getId()));
        log.info("{} was deleted successfully.", user);
    }
}
