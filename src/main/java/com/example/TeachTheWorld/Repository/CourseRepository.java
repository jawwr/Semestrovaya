package com.example.TeachTheWorld.Repository;

import com.example.TeachTheWorld.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
//    List<Course> findCourseByTitleContainingOrDescriptionContaining(String title, String description);
}
