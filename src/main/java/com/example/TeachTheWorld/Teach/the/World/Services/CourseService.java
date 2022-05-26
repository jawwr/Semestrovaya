package com.example.TeachTheWorld.Teach.the.World.Services;

import com.example.TeachTheWorld.Teach.the.World.Models.Course;
import com.example.TeachTheWorld.Teach.the.World.Models.CoursePage;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {
    Course getCourseById(Long id);
    List<Course> getAllCourses();
    void saveCourse(Course course);
    void deleteCourse(Long id);
    CoursePage getCoursePageById(Long id);
}
