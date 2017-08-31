package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.entity.Course;

public interface CourseService {

	public List<Course> listAllCourse();
	
	public Course addCourse(Course course);
	
	public int removeCourse(int id);
	
	public Course updateCourse(Course course);
	
}
