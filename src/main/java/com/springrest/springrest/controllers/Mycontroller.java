package com.springrest.springrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class Mycontroller {
	@Autowired
	private CourseService courseService;
	@GetMapping("/home")
	public String home() {
return "this is the homepage";
	}
	
	
	// get the courses
//	@RequestMapping(path="/courses",method=RequestMethod.GET)
//OR (Alternative for getmapping)
	@GetMapping("/courses")
	public List<Course> getCourses(){
		  
		return this.courseService.getCourses();
		
	} 
	
	@GetMapping("/courses/{courseId}")
	
	public Course getCourse(@PathVariable long courseId) {
		return this.courseService.getCourse(courseId);
	}
	
	@PostMapping("/courses")
	
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
		
		
	}
} 
