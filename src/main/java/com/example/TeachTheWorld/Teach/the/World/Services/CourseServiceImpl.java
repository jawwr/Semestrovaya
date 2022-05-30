package com.example.TeachTheWorld.Teach.the.World.Services;

import com.example.TeachTheWorld.Teach.the.World.Models.Course;
import com.example.TeachTheWorld.Teach.the.World.Models.CoursePage;
import com.example.TeachTheWorld.Teach.the.World.Repository.CoursePageRepository;
import com.example.TeachTheWorld.Teach.the.World.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;
    private final CoursePageRepository coursePageRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, CoursePageRepository coursePageRepository) {
        this.courseRepository = courseRepository;
        this.coursePageRepository = coursePageRepository;
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        courses.forEach(item -> item.setPages(null));
        return courses;
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public CoursePage getCoursePageById(Long id) {
        return coursePageRepository.getById(id);
    }

    @Override
    public List<Course> getAllCoursesWithLimit(int limit) {
        List<Course> courses = courseRepository.findAll();
        courses.subList(limit, courses.size()).clear();
        courses.forEach(item -> item.setPages(null));
        return courses;
    }

    @Override
    public List<Course> searchCourseByParameter(String parameter) {
        return courseRepository.findCourseByTitleContainingOrDescriptionContaining(parameter,parameter);
    }

}
