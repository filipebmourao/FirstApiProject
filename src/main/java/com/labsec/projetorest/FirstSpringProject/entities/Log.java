package com.labsec.projetorest.FirstSpringProject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference  // Evita recursão infinita no JSON
    private User user;

    public Log() {
    }

    public Log(String action, User user, String details) {
        this.action = action;
        this.user = user;
        this.details = details;
    }
}