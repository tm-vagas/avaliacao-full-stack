package com.financial.transfers.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "user_profile")
@NoArgsConstructor
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -1905907502453138175L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String surName;
    private String cpf;
    private String accountNumber;


    public UserEntity(Long id, String name, String surName, String cpf, String accountNumber) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.cpf = cpf;
        this.accountNumber = accountNumber;
    }
}
