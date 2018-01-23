package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.PersonInfoTest_new;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.PersonInformation;

/**
 * Testy jednostkowe klasy PersonInformation. 
 * Sprawdzenie czy klasa PersonInformation poprawnie wczytuje i zwraca zale¿ne od niej obiekty i pola reprezentuj¹cê typy proste  
 */
@RunWith(MockitoJUnitRunner.class)
public class TestPersonInformation extends Mockito{

	public long id;
	public String name;
	public String surname;
	public String placeOfBirth;
	public int old;
	public String pesel;
	
	@Mock
	public Date dateOfBirth;
	
	@InjectMocks
	PersonInformation personInfo;
	
	public TestPersonInformation() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 *  Ustawienia inicjalizacyjne dla testów
	 */
	@Before
	public  void setup() {
			personInfo = new PersonInformation();
			dateOfBirth = mock(Date.class);
			id = 123l;
			name = "testName";
			surname = "testSurname";
			placeOfBirth = "testPlace";
			old = 1234;
			pesel = "testPesel";
	}
	
	/**
	 * Test czy gettery i settery pola id operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetIdAndGetId_isInsideTheSameLongValue_true() {
		personInfo.setId(id);
		assertThat(personInfo.getId()).isEqualTo(123);
	}
	
	/**
	 * Test czy gettery i settery pola name operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetNameAndGetName_isInsideTheSameStringObject_true() {
		personInfo.setName(name);
		assertThat(personInfo.getName()).isEqualTo("testName");
	}
	
	/**
	 * Test czy gettery i settery pola surname operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetSurnameAndGetSurname_isInsideTheSameStringObject_true() {
		personInfo.setSurName(surname);
		assertThat(personInfo.getSurName()).isEqualTo("testSurname");
	}
	
	/**
	 * Test czy gettery i settery pola placeOfBirth operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetPlaceOfBirthAndGetPlaceOfBirth_isInsideTheSameStringObject_true() {
		personInfo.setPlaceOfBirth(placeOfBirth);
		assertThat(personInfo.getPlaceOfBirth()).isEqualTo("testPlace");
	}
	
	/**
	 * Test czy gettery i settery pola old operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetOldAndGetOld_isInsideTheSameIntValue_true() {
		personInfo.setOld(old);
		assertThat(personInfo.getOld()).isEqualTo(1234);
	}
	
	/**
	 * Test czy gettery i settery pola pesel operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetPeselAndGetPesel_isInsideTheSameStringObject_true() {
		personInfo.setPesel(pesel);
		assertThat(personInfo.getPesel()).isEqualTo("testPesel");
	}
	
	/**
	 * Test czy gettery i settery pola dateOfBirth operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testDateOfBirthAndGetDateOfBirth_isInsideTheSameDateOfBirthObject_true() {
		personInfo.setDateOfBirth(dateOfBirth);
		assertThat(personInfo.getDateOfBirth()).isEqualTo(dateOfBirth);
	}
}
