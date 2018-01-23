package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.PersonInfoTest_new;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.Employee;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Course;

/**
 * Testy jednostkowe klasy Course. 
 * Sprawdzenie czy klasa Course poprawnie wczytuje i zwraca zale¿ne od niej obiekty i pola reprezentuj¹cê typy proste  
 */
@RunWith(MockitoJUnitRunner.class)
public class TestCourse extends Mockito{

	 	public long id;
	 	public String nameCourse;
	    public int expiredTime;
	    public boolean isRequiredToWork;
	    
	    @Mock
	    public Employee ownerCourse;
	    @Mock
	    public List<Course> courseList;
	    
	    @InjectMocks
	    public Course course;
	    
	    public TestCourse() {
			MockitoAnnotations.initMocks(this);
		}
	    
	    /**
		 *  Ustawienia inicjalizacyjne dla testów
		 */
		@Before
		public  void setup() {
				course = new Course();
				ownerCourse = mock(Employee.class);
				courseList = mock(List.class);
				id = 123l;
				nameCourse = "testName";
				expiredTime = 1234;
				isRequiredToWork = true;
		}
		
		/**
		 * Test czy gettery i settery pola id operuj¹ poprawnie na podanej wartoœci
		 */
		@Test
		public void testSetIdAndGetId_isInsideTheSameLongValue_true() {
			course.setId(id);
			assertThat(course.getId()).isEqualTo(123);
		}
	
		/**
		 * Test czy gettery i settery pola nameCourse operuj¹ poprawnie na podanej wartoœci
		 */
		@Test
		public void testSetNameCoursesAndGetNameCourse_isInsideTheSameStringObject_true() {
			course.setNameCourse(nameCourse);
			assertThat(course.getNameCourse()).isEqualTo("testName");
		}
		
		/**
		 * Test czy gettery i settery pola expiredTime operuj¹ poprawnie na podanej wartoœci
		 */
		@Test
		public void testSetExpiredTimeAndGetExpiredTime_isInsideTheSameIntValue_true() {
			course.setExpiredTime(expiredTime);
			assertThat(course.getExpiredTime()).isEqualTo(1234);
		}
		
		/**
		 * Test czy gettery i settery pola isRequiredToWork operuj¹ poprawnie na podanej wartoœci
		 */
		@Test
		public void testSetIsRequiredToWorkAndGeIsRequiredToWork_isInsideTheSameBooleanValue_true() {
			course.setRequiredToWork(isRequiredToWork);
			assertThat(course.isRequiredToWork()).isTrue();
		}
		
		/**
		 * Test czy metoda getCourseList zostanie wywo³ana dwa razy
		 * Test czy Test czy gettery i settery pola ownerCourse operuj¹ poprawnie na podanej wartoœci
		 */
		@Test
		public void testSetCourseListAndGetCourseList_isInsideTheSameObjectTypeEmployee_true() {
			when(ownerCourse.getCourseList()).thenReturn(courseList,courseList);
			course.setOwnerCourse(ownerCourse);
			verify(ownerCourse, times(2)).getCourseList();
			assertThat(course.getOwnerCourse()).isEqualTo(ownerCourse);
		}
}
