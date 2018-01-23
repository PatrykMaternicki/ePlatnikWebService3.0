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

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Education;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Person;

/**
 * Testy jednostkowe klasy Education. 
 * Sprawdzenie czy klasa Education poprawnie wczytuje i zwraca zale¿ne od niej obiekty i pola reprezentuj¹cê typy proste  
 */
@RunWith(MockitoJUnitRunner.class)
public class TestEducation extends Mockito{
	
	public long id;
	public String nameSchool;
	public int startYear;
	public int endYear;
    
	@Mock
	public Person educateThePerson;
	@Mock
	public List<Education> educationList;
	
	@InjectMocks
	public Education education;
	
	public TestEducation() {
		MockitoAnnotations.initMocks(this);
	}
    
    /**
	 *  Ustawienia inicjalizacyjne dla testów
	 */
	@Before
	public  void setup() {
			education = new Education();
			educateThePerson = mock(Person.class);
			educationList = mock(List.class);
			id = 123l;
			nameSchool = "testName";
			startYear = 1234;
			endYear = 12345;
	}
	
	/**
	 * Test czy gettery i settery pola id operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetIdAndGetId_isInsideTheSameLongValue_true() {
		education.setId(id);
		assertThat(education.getId()).isEqualTo(123);
	}
	
	/**
	 * Test czy gettery i settery nameSchool operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetNameSchoolAndGetNameSchool_isInsideTheSameStringObject_true() {
		education.setNameSchool(nameSchool);
		assertThat(education.getNameSchool()).isEqualTo("testName");
	}
	
	/**
	 * Test czy gettery i settery pola startYear operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetStartYearAndGetStartYear_isInsideTheSameIntValue_true() {
		education.setStartYear(startYear);
		assertThat(education.getStartYear()).isEqualTo(1234);
	}
	
	/**
	 * Test czy gettery i settery pola endYear operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetEndYearAndGetEndYear_isInsideTheSameIntValue_true() {
		education.setEndYear(endYear);
		assertThat(education.getEndYear()).isEqualTo(12345);
	}
	
	/**
	 * Test czy metoda getEducationList zostanie wywo³ana dwa razy
	 * Test czy Test czy gettery i settery pola educateThePerson operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetEducateThePersonAndGeteducateThePerson_isInsideTheSameObjectTypePerson_true() {
		when(educateThePerson.getEducationList()).thenReturn(educationList,educationList);
		education.setEducateThePerson(educateThePerson);
		verify(educateThePerson, times(2)).getEducationList();
		assertThat(education.getEducateThePerson()).isEqualTo(educateThePerson);
	}
}
