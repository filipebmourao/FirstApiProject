package com.labsec.projetorest.FirstSpringProject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "logs")
@Getter
@Setter
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;
    private String details;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Relacionamento com User

    public Log() {
    }

    public Log(String action, User user, String details) {
        this.action = action;
        this.user = user;
        this.details = details;
    }
}