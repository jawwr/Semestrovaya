package com.example.TeachTheWorld.Teach.the.World.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "author_id")
    private Long author_id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private List<CoursePage> pages;

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "text")
    private String description;

}
