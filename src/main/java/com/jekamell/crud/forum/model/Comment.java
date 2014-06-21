package com.jekamell.crud.forum.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    @Size(min = 1, message = "Content can't be empty")
    private String content;

    @Column(name = "id_topic")
    private Long idTopic;

    @Column(name = "id_author")
    private Long idAuthor;

    @Column(name = "date_add")
    @Type(type="timestamp")
    private Date dateAdd;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_topic", referencedColumnName = "id", insertable = false, updatable = false)
    private Topic topic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_author", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Long idTopic) {
        this.idTopic = idTopic;
    }

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
