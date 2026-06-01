package com.aldirneto.mygamerboxd.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Admin extends Usuario {
    private String chaveSeguranca;
}