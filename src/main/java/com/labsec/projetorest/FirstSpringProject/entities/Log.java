package com.labsec.projetorest.FirstSpringProject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="logs")
@Getter
@Setter

public class Log {

    public enum TYPE {
        CREATE,
        UPDATE,
        DELETE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private TYPE action;
    private LocalDateTime timestamp;
    private String ipAddress;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Log(String action, LocalDateTime timestamp, String ipAddress) {
    }

    public Log() {

    }
}
