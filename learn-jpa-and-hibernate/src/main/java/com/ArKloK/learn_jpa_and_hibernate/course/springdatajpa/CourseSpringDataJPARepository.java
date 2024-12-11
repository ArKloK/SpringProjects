package com.ArKloK.learn_jpa_and_hibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ArKloK.learn_jpa_and_hibernate.course.Course;

public interface CourseSpringDataJPARepository extends JpaRepository<Course, Long>{
	
	public List<Course>findByName(String name);
	public List<Course>findByAuthor(String author);

}
