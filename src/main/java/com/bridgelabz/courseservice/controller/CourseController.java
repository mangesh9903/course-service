package com.bridgelabz.courseservice.controller;

import com.bridgelabz.courseservice.entity.Course;
import com.bridgelabz.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/id")
    public Course getById(@RequestParam(value = "id", defaultValue = "1") int id) {
        return courseService.getById(id);
    }

    @PostMapping
    public boolean create(@RequestBody Course course) {
        return courseService.create(course);
    }

    @PutMapping("/updateCourse/{courseId}")
    public boolean update(@PathVariable int courseId, @RequestBody Course course) {
        return courseService.update(courseId, course);
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public boolean delete(@PathVariable int courseId) {
        return courseService.delete(courseId);
    }
}
