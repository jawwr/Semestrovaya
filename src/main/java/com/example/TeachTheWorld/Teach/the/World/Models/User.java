package com.example.TeachTheWorld.Teach.the.World.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 20)
    private String name;

    @Column(name = "nickname", nullable = false)
    @Size(min = 2, max = 20)
    private String nickname;

    @Column(name = "password")
    private String password;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private List<Course> myCourses;
}
