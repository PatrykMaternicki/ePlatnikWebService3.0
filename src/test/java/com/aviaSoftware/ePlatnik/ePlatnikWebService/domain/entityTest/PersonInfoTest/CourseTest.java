package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.PersonInfoTest;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Setups.HibernateSetup;
import org.junit.Before;
import org.junit.Test;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Course;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class CourseTest extends HibernateSetup {

	private EntityManager em;
	private Course course;
	private Course entity;
	private String textContext = "TEST";
	@Before
	public void setUp(){
		super.createPU();
		em = super.getEm();
		course = new Course();
		course.setNameCourse(textContext);
		course.setExpiredTime(2);
		course.setRequiredToWork(true);
		em.getTransaction().begin();
		em.persist(course);
		em.getTransaction().commit();
		entity = em.find(Course.class,course.getId());
		em.close();

	}
	@Test
	public void nameCourse_should_be_string(){
		assertThat("nameCourse is not String",course.getNameCourse(),is(String.class));
	}
	@Test
	public void testPU_should_be_teturn_nameCourse(){
		assertEquals("Entity nameCourse in table COURSE is not equal field nameCourse in Course Object",course.getNameCourse(),entity.getNameCourse());
	}
	@Test
	public void expiredTime_should_be_integer(){
		assertThat("expiredTime is not Integer",course.getExpiredTime(),is(Integer.class));
	}
	@Test
	public void testPU_should_be_return_expiredTime(){
		assertEquals("Entity expiredTime in table COURSE is not equal field expiredTime in Course Object",course.getExpiredTime(),entity.getExpiredTime());
	}
	@Test
	public void required_work_should_be_boolean(){
		assertThat("Required is not boolean",course.isRequiredToWork(),is(Boolean.class));
	}
	@Test
	public void testPU_should_be_return_requiredWork(){
		assertEquals("Entity requiredWork in table COURSE is not equal field requiredWork in Course Object",course.getExpiredTime(),entity.getExpiredTime());

	}

}