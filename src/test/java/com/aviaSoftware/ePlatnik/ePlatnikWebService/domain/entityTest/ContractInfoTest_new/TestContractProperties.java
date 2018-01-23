package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.ContractInfoTest_new;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.ContractProperties;

/**
 * Testy jednostkowe klasy ContractProperties. 
 * Sprawdzenie czy klasa ContractProperties poprawnie wczytuje i zwraca nale¿¹ce do klasy pola reprezentuj¹cê typy proste 
 */
@RunWith(MockitoJUnitRunner.class)
public class TestContractProperties extends Mockito{

	public ContractProperties contractProperties;
	public Long id;
    public boolean hadStudentStatus;
    public boolean hadRetiredStatus;
    public boolean hadInvalidStatus;
	
	public TestContractProperties() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 *  Ustawienia inicjalizacyjne dla testów
	 */
	@Before
	public  void setup() {
		contractProperties = new ContractProperties();
		id = 123l;
		hadStudentStatus = true;
		hadRetiredStatus = true;
		hadInvalidStatus = true;
	}
	
	/**
	 * Test czy gettery i settery pola id operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetIdsAndGetId_isInsideTheSameLongValue_true() {
		contractProperties.setId(id);
		assertThat(contractProperties.getId()).isEqualTo(123);
	}
	
	/**
	 * Test czy gettery i settery pola hadStudentStatus operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSetHadStudentStatusAndIsHadStudentStatus_isInsideTheSameBooleanValue_true() {
		contractProperties.setHadStudentStatus(true);
		assertThat(contractProperties.isHadStudentStatus()).isTrue();
	}
	
	/**
	 * Test czy gettery i settery pola hadInvalidStatus operuj¹ poprawnie na podanej wartoœci
	 */
	@Test
	public void testSethadRetiredStatusAndIsRetiredStatus_isInsideTheSameBooleanValue_true() {
		contractProperties.setHadInvalidStatus(true);
		assertThat(contractProperties.isHadInvalidStatus()).isTrue();
	}
	
}
