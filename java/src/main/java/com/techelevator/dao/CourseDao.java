package com.techelevator.dao;

import com.techelevator.model.Course;

import java.util.List;

public interface CourseDao {
   Course createCourse(Course course);
    public List<Course> getCourses();
    public Course getCourse(Integer courseId);
    public void updateCourse(Course course, Integer courseId);
    public void deleteCourse(Integer courseId);
}
