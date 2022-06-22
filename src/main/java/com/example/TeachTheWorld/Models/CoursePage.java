package com.example.TeachTheWorld.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
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
    @GeneratedValue
    private Long course_id;

    @Column(name = "number")
    private int numberPage;

    @Column(name = "title")
    private String title;

    @Column(name = "body", columnDefinition = "text")
    private String body;

}
