package com.example.sociallobster.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ENDUSER")
public class User {
    @Id
    private int id;
    private String username;
    private String password;
    private String email;
}