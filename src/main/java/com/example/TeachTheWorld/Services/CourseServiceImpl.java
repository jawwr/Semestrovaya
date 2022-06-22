package com.example.TeachTheWorld.Services;

import com.example.TeachTheWorld.Models.Course;
import com.example.TeachTheWorld.Models.CoursePage;
import com.example.TeachTheWorld.Repository.CoursePageRepository;
import com.example.TeachTheWorld.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return sortedCoursePage(courseRepository.getById(id));
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
//        if (parameter == null) return courseRepository.findAll();
//        return courseRepository.findCourseByTitleContainingOrDescriptionContaining(parameter,parameter);
        List<Course> courses = courseRepository.findAll().stream().filter(item -> item.getTitle().contains(parameter) || item.getDescription().contains(parameter)).collect(Collectors.toList());
        courses.forEach(item -> item.setPages(null));
        return courses;
    }

    private Course sortedCoursePage(Course course){
        List<CoursePage> pages = course.getPages();
        for (int i = 0; i < pages.size() - 1; i++) {
            for (int j = 0; j < pages.size() - 1; j++) {
                if (pages.get(j).getNumberPage() > pages.get(j + 1).getNumberPage()) {
                    var intermediateCourse = pages.get(j);
                    pages.set(j, pages.get(j + 1));
                    pages.set(j + 1, intermediateCourse);
                }
            }
        }
        return course;
    }
}
