package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.ContractInfoTest_new;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.Contract;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.RaportOfWork;


/**
 * Testy jednostkowe klasy RaportOfWork. 
 * Sprawdzenie czy klasa RaportOfWork poprawnie wczytuje i zwraca zale¿ne od niej obiekty i pola reprezentuj¹cê typy proste  
 */
@RunWith(MockitoJUnitRunner.class)
public class TestRaportOfWork extends Mockito{
	
	 	public Long id;
	 	public int month;
	 	public int year;
	    public int workDays;
	    public int workHours;
	
	/**
	 * Mock dla klas zale¿nych od klasy RaportOfWork
	 * 
	 */
	@Mock
	public Contract owner_raport;
	@Mock
	public ArrayList<RaportOfWork> rofwMock;
	
	@InjectMocks
	public RaportOfWork rofw;
	
	public TestRaportOfWork() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 *  Ustawienia inicjalizacyjne dla testów
	 */
	@Before
	public  void setup() {
		rofw = new RaportOfWork();
		owner_raport = mock(Contract.class);
		rofwMock = mock(ArrayList.class);
		id = 123l;
		month = 1234;
		year = 12345;
		workDays = 123456;
		workHours = 1234567;
	}
	
	/**
	 * Test czy gettery i settery pola id operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetIdsAndGetId_isInsideTheSameLongValue_true() {
		rofw.setId(id);
		assertThat(rofw.getId()).isEqualTo(123);
	}
	
	/**
	 * Test czy gettery i settery pola month operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetMonthAndGetMonth_isInsideTheSameIntValue_true() {
		rofw.setMonth(month);
		assertThat(rofw.getMonth()).isEqualTo(1234);
	}
	
	/**
	 * Test czy gettery i settery pola year operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetYearAndGetYear_isInsideTheSameIntValue_true() {
		rofw.setYear(year);
		assertThat(rofw.getYear()).isEqualTo(12345);
	}
	
	/**
	 * Test czy gettery i settery pola workDays operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetWorkDaysAndGetWorkDays_isInsideTheSameIntValue_true() {
		rofw.setWorkDays(workDays);
		assertThat(rofw.getWorkDays()).isEqualTo(123456);
	}
	
	/**
	 * Test czy gettery i settery pola workHours operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetWorkHoursAndGetWorkHours_isInsideTheSameIntValue_true() {
		rofw.setWorkHours(workHours);
		assertThat(rofw.getWorkHours()).isEqualTo(1234567);
	}
	
	/**
	 * Test czy metoda getRaports zostanie wywo³ana dwa razy
	 * Test czy Test czy gettery i settery pola owner_raport operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetRaportOfWorkAndGetRaportOfWork_isInsideTheSameObjectTypeContract_true() {
		when(owner_raport.getRaports()).thenReturn(rofwMock,rofwMock);
		rofw.setOwner_raport(owner_raport);
		verify(owner_raport, times(2)).getRaports();
		assertThat(rofw.getOwner_raport()).isEqualTo(owner_raport);
	}
}
