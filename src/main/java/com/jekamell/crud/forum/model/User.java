package com.jekamell.crud.forum.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.File;

@Entity
@Table(name = "user")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "login", unique = true)
    @Size(min = 2, max = 20, message = "Username length cant be less then 6 and longer then 20")
    @Pattern(regexp = "^\\w+$", message = "Username can contains alphanumeric only")
    private String login;

    @Column(name = "password")
    @Size(min = 6, message = "Password length cant be less then 6 and longer then 20")
    private String password;

    @Column(name = "email")
    @Email(message = "Invalid E-mail address")
    private String email;

    @Column(name = "id_role")
    private Long idRole;

    @ManyToOne
    @JoinColumn(name = "id_role", insertable = false, updatable = false)
    private UserRole role;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column
    private String skype;

    @Column(name = "name_first")
    private String nameFirst;

    @Column(name = "name_last")
    private String nameLast;

    @Transient
    private String avatar;

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

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public boolean isNewRecord() {
        return getId() == null;
    }

    //TODO: try to find solution how to get resource inside webapp
    public String getAvatar() {
        String webAppPath = "/home/mell/IdeaProjects/forum/src/main/webapp";
        String basePath = webAppPath + "/resources/img/avatar/";

        File avatar = new File(basePath + getId() + ".jpg");
        System.out.println(basePath + getId() + ".jpg");
        if (avatar.isFile()) {
            this.avatar =  avatar.getPath().replaceAll(webAppPath, "");
            return this.avatar;
        }

        return (basePath + "avatar-default.jpg").replaceAll(webAppPath, "");
    }


}
