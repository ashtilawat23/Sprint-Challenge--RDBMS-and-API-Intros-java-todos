package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todos extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // ------- Table Fields ---------
    private long todoid; // primary key

    @Column(nullable = false)
    private String description;

    private boolean completed = false; //Note that for all new todos, default completed to false

    // -------- Association Table Fields ----------
    //userid foreign key (one user to many todos) not null
    @ManyToOne()
    @JoinColumn(name = "userid",
            nullable = false)
    @JsonIgnoreProperties(value = "todos", allowSetters = true)
    private User user;


    // --------- Constructors --------------
    // Note: do not add id to constructor
    public Todos()
    {
        // default constructor for JPA
    }

    // Constructor with parameters


    public Todos(
            User user,
            String description)
    {
        this.user = user;
        this.description = description;

    }

    // ----------- Getters and Setters --------------
    // Note: make a getter and setter for primary key id
    public long getTodoid()
    {
        return todoid;
    }

    public void setTodoid(long todoid)
    {
        this.todoid = todoid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    // ----- Association Getter and Setter
    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}