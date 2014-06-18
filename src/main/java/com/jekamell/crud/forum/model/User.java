package com.jekamell.crud.forum.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "login", unique = true)
    @Size(min = 6, max = 20, message = "Username length cant be less then 6 and longer then 20")
    @Pattern(regexp = "^\\w+$", message = "Username can contains alphanumeric only")
    private String login;

    @Column(name = "password")
    @Size(min = 6, max = 20, message = "Password length cant be less then 6 and longer then 20")
    private String password;

    @Column(name = "email")
    @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "Invalid E-mail address")
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private UserRole role;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
}
