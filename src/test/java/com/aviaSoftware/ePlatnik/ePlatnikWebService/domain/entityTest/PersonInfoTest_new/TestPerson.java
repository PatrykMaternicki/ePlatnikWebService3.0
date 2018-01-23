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

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Address;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Education;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Person;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.PersonInformation;

/**
 * Testy jednostkowe klasy Person. 
 * Sprawdzenie czy klasa Person poprawnie wczytuje i zwraca zale¿ne od niej obiekty i pola reprezentuj¹cê typy proste  
 */
@RunWith(MockitoJUnitRunner.class)
public class TestPerson extends Mockito{

    public long id;
    
    @Mock
    public Address address;
    @Mock
    public PersonInformation personInformation;
    @Mock
    public List<Education> educationList;
    @Mock
    public Education education;
    
    @InjectMocks
    Person person;
    
    public TestPerson() {
		MockitoAnnotations.initMocks(this);
	}
    
    /**
	 *  Ustawienia inicjalizacyjne dla testów
	 */
	@Before
	public  void setup() {
			person = new Person();
			address = mock(Address.class);
			personInformation = mock(PersonInformation.class);
			educationList = mock(List.class);
			education = mock(Education.class);
			id = 123l;
	}
	
	/**
	 * Test czy gettery i settery pola id operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetIdAndGetId_isInsideTheSameLongValue_true() {
		person.setId(id);
		assertThat(person.getId()).isEqualTo(123);
	}
	
	/**
	 * Test czy gettery i settery pola address operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetAddressAndGetAddress_isInsideTheSameAddressObject_true() {
		person.setAdress(address);
		assertThat(person.getAdress()).isEqualTo(address);
	}
	
	/**
	 * Test czy gettery i settery pola personInformation operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetPersonInformationAndGetPersonInformation_isInsideTheSamePersonInformationObject_true() {
		person.setInformation(personInformation);
		assertThat(person.getInformation()).isEqualTo(personInformation);
	}
	
	/**
	 * Test czy gettery i settery pola educationList operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetEducationListAndGetEducationList_isInsideTheSameEducationListObject_true() {
		person.setEducationList(educationList);
		when(educationList.get(0)).thenReturn(education);
		assertThat(educationList.get(0)).isEqualTo(education);
	}

}
