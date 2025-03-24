package com.labsec.projetorest.FirstSpringProject.services;

import com.labsec.projetorest.FirstSpringProject.entities.User;
import com.labsec.projetorest.FirstSpringProject.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final LogService logService;

    public UserService(UserRepository userRepository, LogService logService) {
        this.userRepository = userRepository;
        this.logService = logService;
    }

    public User createUser(User user) {
        User savedUser = userRepository.save(user); // Salva o usuário
        logService.logAction("CREATE_USER", savedUser.getId(), "Usuário criado com sucesso");
        return savedUser;
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword()); // Atualiza a senha
        User updatedUser = userRepository.save(existingUser); // Salva as alterações
        logService.logAction("UPDATE_USER", updatedUser.getId(), "Usuário atualizado com sucesso");
        return updatedUser;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id); // Deleta o usuário
        logService.logAction("DELETE_USER", id, "Usuário deletado com sucesso");
    }
}