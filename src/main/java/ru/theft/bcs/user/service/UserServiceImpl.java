package ru.theft.bcs.user.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.theft.bcs.user.model.User;
import ru.theft.bcs.user.repository.UserRepository;
import ru.theft.bcs.util.exception.NotFoundException;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        log.info("Quantity users: {}", userRepository.findAll().size());
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User doesn't exist by " + id + " id."));
    }

    @Override
    public User add(User user) {
        log.info("{} has been created.", user);
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(getById(user.getId()));
        log.info("{} has been deleted.", user);
    }
}
