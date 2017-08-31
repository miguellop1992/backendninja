package com.udemy.backendninja.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.entity.QCourse;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
	
	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	public void find(boolean exist) {
		JPAQuery<Course> query = new JPAQuery<>(em);
		// Retornar un curso
		Course course = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
	
		// Retornar nombre y descripcion
		Course course2 =(Course) query.select(qCourse.name,qCourse.description).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
		
		// Retornar un lista de cursos que la hora esten entre 20 y 50
		List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
	
		// Retorna resultado dependiendo del condicional
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
		
		
		if(exist) {
			Predicate predicate2 = (Predicate)qCourse.id.eq(23);
			predicateBuilder.and(predicate2);
		}else {
			Predicate predicate3 = (Predicate)qCourse.name.endsWith("OP");
			predicateBuilder.or(predicate3);
			
		}
		
		Course course3 = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
	}
}
