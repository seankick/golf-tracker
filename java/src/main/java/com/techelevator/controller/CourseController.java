package com.techelevator.controller;

import com.techelevator.dao.CourseDao;
import com.techelevator.model.Course;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/courses")

public class CourseController {

    private CourseDao courseDao;

    public CourseController(CourseDao courseDao) {this.courseDao = courseDao;}

    //create course works
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Course createCourse(@Valid @RequestBody Course course) {
        return courseDao.createCourse(course);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Course> getCourses() {
        return courseDao.getCourses();
    }

    @RequestMapping(value = "/{courseID}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable Integer courseID) {

        return courseDao.getCourse(courseID);
    }

    @RequestMapping(value = "/{courseID}", method = RequestMethod.PUT)

    public void updateCourse(@Valid @RequestBody Course course, @PathVariable Integer courseID){
        courseDao.updateCourse(course, courseID);
    }

    @RequestMapping(value = "/{courseID}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable Integer courseID) {
        courseDao.deleteCourse(courseID);
    }
}
