package com.example.TeachTheWorld.Teach.the.World.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 20)
    private String name;

    @Column(name = "surname", nullable = false)
    @Size(min = 2, max = 20)
    private String surname;

    @Column(name = "nickname", nullable = false)
    @Size(min = 2, max = 20)
    private String nickname;

    @Column(name = "email", nullable = false)
    @Email
    private String email;
}
