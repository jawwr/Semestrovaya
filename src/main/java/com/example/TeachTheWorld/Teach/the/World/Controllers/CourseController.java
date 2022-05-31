package com.example.TeachTheWorld.Teach.the.World.Controllers;

import com.example.TeachTheWorld.Teach.the.World.Models.Course;
import com.example.TeachTheWorld.Teach.the.World.Models.CoursePage;
import com.example.TeachTheWorld.Teach.the.World.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return service.getCourseById(id);
    }

    @GetMapping("")
    public List<Course> getAllCourses(@RequestParam(required = false) String limit){
        if (limit != null) return service.getAllCoursesWithLimit(Integer.parseInt(limit));
        return service.getAllCourses();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCourse(@RequestBody Course course){
        service.saveCourse(course);
        return ResponseEntity.ok().body("Курс успешно создан");
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") Long id){
        service.deleteCourse(id);
        return ResponseEntity.ok().body("Курс успешно удален");
    }

    @GetMapping("/{courseId}/{pageId}")
    public CoursePage getCoursePage(@PathVariable("courseId") Long courseId, @PathVariable("pageId") Long pageId){
        return service.getCoursePageById(pageId);
    }

    @GetMapping("/search")
    public List<Course> searchCourses(@RequestParam(required = false) String parameter){
        return service.searchCourseByParameter(parameter);
    }
}