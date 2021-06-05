package com.codetogive.patatasfritas.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Column(name = "Name")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String emailAddress;

//    @Enumerated(EnumType.STRING)
    @Column(name = "Roles")
    private String role;

    public User(String username, String password, String emailAddress, String role) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.role = role;
    }
}
