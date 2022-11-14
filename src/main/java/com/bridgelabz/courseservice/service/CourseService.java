package com.bridgelabz.courseservice.service;

import com.bridgelabz.courseservice.entity.Course;

import java.util.List;

public interface CourseService {

    boolean create(Course course);

    Course getById(int courseId);

    List<Course> getAll();

    boolean update(int courseId, Course course);

    boolean delete(int courseId);
}
