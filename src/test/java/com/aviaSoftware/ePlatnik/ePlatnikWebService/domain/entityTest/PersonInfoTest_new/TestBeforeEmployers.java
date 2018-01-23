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
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.BeforeEmployers;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Course;

/**
 * Testy jednostkowe klasy BeforeEmployers. 
 * Sprawdzenie czy klasa BeforeEmployers poprawnie wczytuje i zwraca zale¿ne od niej obiekty i pola reprezentuj¹cê typy proste  
 */
@RunWith(MockitoJUnitRunner.class)
public class TestBeforeEmployers extends Mockito{
	
	public long id;
	public String nameEmployers;
    public int startYearWork;
    public int endYearWork;
    public int endMonthWork;
    public int startMonthWork;
    
    @Mock
    public Employee ownerBeforeEmployers;
    @Mock
    public List<BeforeEmployers> befEmpMock;
    
    @InjectMocks
    public BeforeEmployers befEmp;
    
    public TestBeforeEmployers() {
		MockitoAnnotations.initMocks(this);
	}
    
    /**
	 *  Ustawienia inicjalizacyjne dla testów
	 */
	@Before
	public  void setup() {
		befEmp = new BeforeEmployers();
		ownerBeforeEmployers = mock(Employee.class);
		befEmpMock = mock(List.class);
		id =123l;
		nameEmployers = "testName";
		startYearWork = 1234;
		endYearWork = 12345;
		endMonthWork = 123456;
		startMonthWork = 1234567;		
	}
	
	/**
	 * Test czy gettery i settery pola id operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetIdsAndGetId_isInsideTheSameLongValue_true() {
		befEmp.setId(id);
		assertThat(befEmp.getId()).isEqualTo(123);
	}
	
	/**
	 * Test czy gettery i settery pola nameEmployers operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetNameEmployersAndGetNameEmployers_isInsideTheSameStringObject_true() {
		befEmp.setNameEmployers(nameEmployers);
		assertThat(befEmp.getNameEmployers()).isEqualTo("testName");
	}
	
	/**
	 * Test czy gettery i settery pola startYearWork operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetStartYearWorkAndGetStartYearWork_isInsideTheSameIntValue_true() {
		befEmp.setStartYearWork(startYearWork);
		assertThat(befEmp.getStartYearWork()).isEqualTo(1234);
	}
	
	/**
	 * Test czy gettery i settery pola endYearWork operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetEndYearWorkAndGetEndYearWork_isInsideTheSameIntValue_true() {
		befEmp.setEndYearWork(endYearWork);
		assertThat(befEmp.getEndYearWork()).isEqualTo(12345);
	}
	
	/**
	 * Test czy gettery i settery pola endMonthWork operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetEndMonthWorkAndGetEndMonthWork_isInsideTheSameintValue_true() {
		befEmp.setEndMonthWork(endMonthWork);
		assertThat(befEmp.getEndMonthWork()).isEqualTo(123456);
	}
	
	/**
	 * Test czy gettery i settery pola startMonthWork operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetStartMonthWorkAndGetStartMonthWork_isInsideTheSameIntValue_true() {
		befEmp.setStartMonthWork(startMonthWork);
		assertThat(befEmp.getStartMonthWork()).isEqualTo(1234567);
	}
	
	/**
	 * Test czy metoda getBeforeEmployersList zostanie wywo³ana dwa razy
	 * Test czy Test czy gettery i settery pola ownerBeforeEmployers operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetOwnerBeforeEmployersAndGetBeforeEmployers_isInsideTheSameObjectTypeEmployee_true() {
		when(ownerBeforeEmployers.getBeforeEmployersList()).thenReturn(befEmpMock,befEmpMock);
		befEmp.setOwnerBeforeEmployers(ownerBeforeEmployers);
		verify(ownerBeforeEmployers, times(2)).getBeforeEmployersList();
		assertThat(befEmp.getOwnerBeforeEmployers()).isEqualTo(ownerBeforeEmployers);
	}
}
