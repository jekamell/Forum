package com.jekamell.crud.forum.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_role")
public class UserRole {
    public final static long ROLE_USER = 1;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="code")
    private String code;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
