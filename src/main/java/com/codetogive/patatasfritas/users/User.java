package com.codetogive.patatasfritas.users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;

    @Column(name = "Name")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String emailAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    private UserRole role;

    public User(String username, String password, String emailAddress, UserRole role) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.role = role;
    }
}
