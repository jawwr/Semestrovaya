package com.example.TeachTheWorld.Services;

import com.example.TeachTheWorld.Models.Course;
import com.example.TeachTheWorld.Models.CoursePage;

import java.util.List;

public interface CourseService {
    Course getCourseById(Long id);
    List<Course> getAllCourses();
    void saveCourse(Course course);
    void deleteCourse(Long id);
    CoursePage getCoursePageById(Long id);
    List<Course> getAllCoursesWithLimit(int limit);
    List<Course> searchCourseByParameter(String parameter);
}
