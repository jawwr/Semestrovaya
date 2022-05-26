package com.example.TeachTheWorld.Teach.the.World.Controllers;

import com.example.TeachTheWorld.Teach.the.World.Models.Course;
import com.example.TeachTheWorld.Teach.the.World.Models.CoursePage;
import com.example.TeachTheWorld.Teach.the.World.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService service;

    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable("id") Long id){
        var course = service.getCourseById(id);
        return course;
    }

    @GetMapping("/")
    public List<Course> getAllCourses(){
        return service.getAllCourses();
    }

    @PostMapping("/create")
    public void createCourse(@RequestBody Course course){
        service.saveCourse(course);
    }

    @PostMapping("/delete/{id}")
    public void deleteCourse(@PathVariable("id") Long id){
        service.deleteCourse(id);
    }

    @GetMapping("/{courseId}/{pageId}")
    public CoursePage getCoursePage(@PathVariable("courseId") Long courseId, @PathVariable("pageId") Long pageId){
        return service.getCoursePageById(pageId);
    }
}