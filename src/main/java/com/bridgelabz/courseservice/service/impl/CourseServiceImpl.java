package com.bridgelabz.courseservice.service.impl;

import com.bridgelabz.courseservice.entity.Course;
import com.bridgelabz.courseservice.exception.CourseNotFoundException;
import com.bridgelabz.courseservice.repository.CourseRepository;
import com.bridgelabz.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public boolean create(Course course) {
        courseRepository.save(course);
        return true;
    }

    @Override
    public Course getById(int courseId) {
        return courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException("Course Not Found!!!"));
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public boolean update(int courseId, Course updatedCourse) {
        Course oldCourse = getById(courseId);
        oldCourse.setName(updatedCourse.getName());
        oldCourse.setDuration(updatedCourse.getDuration());
        courseRepository.save(oldCourse);
        return true;
    }

    @Override
    public boolean delete(int courseId) {
        courseRepository.deleteById(courseId);
        return true;
    }
}
