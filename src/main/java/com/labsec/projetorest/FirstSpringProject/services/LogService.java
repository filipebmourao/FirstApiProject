package com.labsec.projetorest.FirstSpringProject.services;

import com.labsec.projetorest.FirstSpringProject.entities.Log;
import com.labsec.projetorest.FirstSpringProject.entities.User;
import com.labsec.projetorest.FirstSpringProject.repositories.LogRepository;
import com.labsec.projetorest.FirstSpringProject.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    private final LogRepository logRepository;
    private final UserRepository userRepository;

    public LogService(LogRepository logRepository, UserRepository userRepository) {
        this.logRepository = logRepository;
        this.userRepository = userRepository;
    }

    public void logAction(String action, Long userId, String details) {
        // Busca o usuário pelo ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Cria e salva o log
        Log log = new Log(action, user, details);
        logRepository.save(log);
    }
}