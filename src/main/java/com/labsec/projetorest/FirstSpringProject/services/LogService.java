package com.labsec.projetorest.FirstSpringProject.services;

import com.labsec.projetorest.FirstSpringProject.entities.Log;
import com.labsec.projetorest.FirstSpringProject.repositories.LogRepository;
import com.labsec.projetorest.FirstSpringProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class LogService {
    private final LogRepository logRepository;

    @Autowired
    private UserRepository userRepository;


    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }


    public List<Log> listLogs() {
        return logRepository.findAll();
    }

}
