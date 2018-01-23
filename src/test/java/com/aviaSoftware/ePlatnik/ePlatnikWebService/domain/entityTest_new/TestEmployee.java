package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest_new;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.*;


import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.Employee;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.Contract;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Address;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.BeforeEmployers;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Course;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Person;

/**
 * Testy jednostkowe klasy Employee. 
 * Sprawdzenie czy klasa Employee poprawnie wczytuje i zwraca zale¿ne od niej obiekty i pola reprezentuj¹cê typy proste 
 */
@RunWith(MockitoJUnitRunner.class)
public class TestEmployee extends Mockito{

	/**
	 * Mock dla klas zale¿nych od klasy Employee
	 * 
	 */
	@Mock
	public Person person;
	@Mock
	public Contract contract;
	@Mock
	public List<BeforeEmployers> beforeEmployersList;
	@Mock
	public ArrayList<Course> courseList;
	@Mock
	public Address address;
	@Mock
	public Course course;
	@Mock
	public BeforeEmployers beforeEmployers;
	
	@InjectMocks
	public Employee employee;
	
	public TestEmployee() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 *  Ustawienia inicjalizacyjne dla testów
	 */
	@Before
	public  void setup() {
		person = mock(Person.class);
		contract = mock(Contract.class);
		beforeEmployersList = mock(List.class);
		courseList = mock(ArrayList.class);
		address = mock(Address.class);
		course = mock(Course.class);
		beforeEmployers = mock(BeforeEmployers.class);
	}
	
	/**
	 * Test czy gettery i settery obiektu Person operuj¹ poprawnie i na tym samym obiekcie
	 */
	@Test
	public void testSetPersonAndGetPerson_isInsideTheSamePersonObject_true() {
		employee = new Employee();
		when(person.getAdress()).thenReturn(address);
		employee.setPerson(person);
		assertThat(employee.getPerson().getAdress()).isEqualTo(address);
	}
	
	/**
	 * Test czy gettery i settery obiektu Contract operuj¹ poprawnie i na tym samym obiekcie
	 */
	@Test
	public void testSetContractAndGetContract_isInsideTheSameContractObject_true() {
		employee = new Employee();
		when(contract.getId()).thenReturn(123l);
		employee.setContract(contract);
		assertThat(employee.getContract().getId()).isEqualTo(123l);
	}
	
	/**
	 * Test czy gettery i settery obiektu BeforeEmployersList operuj¹ poprawnie i na tym samym obiekcie
	 */
	@Test
	public void testSetBeforeEmplyersListAndGetBeforeEmployersList_isInsideTheSameBeforeEmployersListObject_true() {
		employee = new Employee();
		when(beforeEmployersList.size()).thenReturn(123);
		employee.setBeforeEmployersList(beforeEmployersList);
		assertThat(employee.getBeforeEmployersList().size()).isEqualTo(123);
	}
	
	/**
	 * Test czy gettery i settery obiektu CourseList operuj¹ poprawnie i na tym samym obiekcie
	 */
	@Test
	public void testSetCourseListAndGetCourseList_isInsideTheSameCourseListObject_true() {
		employee = new Employee();
		when(courseList.size()).thenReturn(123);
		employee.setCourseList(courseList);
		assertThat(employee.getCourseList().size()).isEqualTo(123);
	}
	
	/**
	 * Test czy obiekt Course dodaje sie do listy
	 */
	@Test
	public void testAddCourse_isCourseAddToList_true() {
		employee = new Employee();
		when(course.getNameCourse()).thenReturn("testCourse");
		employee.addCourse(course);
		assertThat(employee.getCourseList().get(0).getNameCourse()).isEqualTo("testCourse");
	}
	
	/**
	 * Test czy obiekt BeforeEmployers dodaje sie do listy
	 */
	@Test
	public void testAddBeforeEmployers_isBeforeEmployersAddToList_true() {
		employee = new Employee();
		when(beforeEmployers.getNameEmployers()).thenReturn("testName");
		employee.addBeforeEmployers(beforeEmployers);
		assertThat(employee.getBeforeEmployersList().get(0).getNameEmployers()).isEqualTo("testName");
	}
	
	/**
	 * Test czy obiekt Employee zapamiêtuje i zwraca wartoœæ pola id
	 */
	@Test
	public void testSetId_isIdRememberInObject_true() {
		employee = new Employee();
		employee.setId(123l);
		assertThat(employee.getId()).isEqualTo(123l);
	}
}
