package com.labsec.projetorest.FirstSpringProject.controllers;

import com.labsec.projetorest.FirstSpringProject.entities.Log;
import com.labsec.projetorest.FirstSpringProject.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")

public class LogController {
    @Autowired
    private LogService logService;

  @GetMapping("/logs/list")
    public List<Log> listLogs() {
      return logService.listLogs();
  }

}
