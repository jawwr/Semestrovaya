package com.example.TeachTheWorld.Teach.the.World.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "coursePages")
public class CoursePage {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "course_id")
    private Long course_id;

    @Column(name = "title")
    private String title;

    @Column(name = "body", columnDefinition = "text")
    private String body;

}
