package com.example.tuwaiqacademylab12.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Password can't be empty")
    @Column(nullable = false)
    private String username;

    @NotEmpty(message = "Password can't be empty")
    @Column(nullable = false)
    private String password;

    @Column
    private String role;

    @OneToMany(mappedBy = "user")
    private Set<Blog> blogs;
}
