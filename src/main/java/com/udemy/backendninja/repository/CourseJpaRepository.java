package com.udemy.backendninja.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.backendninja.entity.Course;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable>{

	public Course findByPrice(int price);
	
	public Course findByPriceAndName(int price,String name);
	
	public List<Course> findByNameOrderByHours(String name);
	
	public Course findByNameOrPrice(String name,int price);

}


