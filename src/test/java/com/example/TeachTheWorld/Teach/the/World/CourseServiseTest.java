package com.example.TeachTheWorld.Teach.the.World;

import com.example.TeachTheWorld.Models.Course;
import com.example.TeachTheWorld.Models.CoursePage;
import com.example.TeachTheWorld.Services.CourseServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseServiseTest {

    @Autowired
    private CourseServiceImpl courseService;

    @Test
    public void sortCoursePageTest(){
        Course course = new Course();
        List<CoursePage> pages = new ArrayList<>();
        pages.add(new CoursePage(4L, 2L, 4, "title4", "body4"));
        pages.add(new CoursePage(2L, 2L, 2, "title2", "body2"));
        pages.add(new CoursePage(3L, 2L, 3, "title3", "body3"));
        pages.add(new CoursePage(1L, 2L, 1, "title1", "body1"));
        course.setPages(pages);
//        course = courseService.sortedCoursePage(course);
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1;i <= 4;i++){
            integerList.add(i);
        }
        List<Integer> numberPages = new ArrayList<>();
        for (var c : course.getPages()){
            numberPages.add(c.getNumberPage());
        }
        Assert.assertEquals(integerList,numberPages);
    }
}
