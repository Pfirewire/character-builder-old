package com.pfirewire.characterbuilder.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    // All private variables, attached to users table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;
    @NotBlank
    @Column(nullable = false, unique = true)
    private String username;
    @NotBlank
    @Size(min = 8, message = "Password must have at least 8 characters.")
    @Column(nullable = false)
    @JsonIgnore
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<PlayerCharacter> characters;


    // Constructor functions
    public User () {}
    public User (String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public User (User copy) {
        this.id = copy.id;
        this.email = copy.email;
        this.username = copy.username;
        this.password = copy.password;
    }


    // Getters and Setters
    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail () { return this.email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername () { return this.username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword () { return this.password; }
    public void setPassword(String password) { this.password = password; }

}
