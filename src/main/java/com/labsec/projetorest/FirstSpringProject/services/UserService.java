package com.labsec.projetorest.FirstSpringProject.services;

import com.labsec.projetorest.FirstSpringProject.entities.User;
import com.labsec.projetorest.FirstSpringProject.repositories.LogRepository;
import com.labsec.projetorest.FirstSpringProject.repositories.UserRepository;
import org.springframework.stereotype.Service;



@Service

public class UserService {
    private final UserRepository userRepository;
    private final LogRepository logRepository;

    public UserService(UserRepository userRepository, LogRepository logRepository) {
        this.userRepository = userRepository;
        this.logRepository = logRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }


}
