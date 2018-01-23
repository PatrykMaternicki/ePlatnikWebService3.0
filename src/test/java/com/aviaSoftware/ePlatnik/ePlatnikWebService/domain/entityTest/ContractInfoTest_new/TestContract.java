package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.ContractInfoTest_new;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.Contract;


	/**
	 * Testy jednostkowe klasy Contract. 
	 * Sprawdzenie czy klasa Contract poprawnie wczytuje i zwraca nale¿¹ce do klasy pola reprezentuj¹cê typy proste 
	 */
	@RunWith(MockitoJUnitRunner.class)
	public class TestContract extends Mockito{
		
		public Contract contract;
		public Long id;
	    public String typeContract;
	    public String startTimeContract;
	    public String endTimeContract;
	    public int freeDay;
		
		public TestContract() {
			MockitoAnnotations.initMocks(this);
		}
		
		/**
		 *  Ustawienia inicjalizacyjne dla testów
		 */
		@Before
		public  void setup() {
			contract = new Contract();
			id = 123l;
		    typeContract = "testStringType";
		    startTimeContract = "testStringStartTime";
		    endTimeContract = "testStringEndTime";
		    freeDay = 1234;
		}
		
		/**
		 * Test czy gettery i settery pola id operuj¹ poprawnie na podanej wartoœci
		 */
		@Test
		public void testSetIdsAndGetId_isInsideTheSameLongValue_true() {
			contract.setId(id);
			assertThat(contract.getId()).isEqualTo(123);
		}
		
		/**
		 * Test czy gettery i settery pola typeContract operuj¹ poprawnie i na tym samym obiekcie
		 */
		@Test
		public void testSetTypeContractAndGetTypeContract_isInsideTheSameStringObject_true() {
			contract.setTypeContract(typeContract);
			assertThat(contract.getTypeContract()).isEqualTo("testStringType");
		}
		
		/**
		 * Test czy gettery i settery pola startTimeContract operuj¹ poprawnie i na tym samym obiekcie
		 */
		@Test
		public void testSetStartTimeContractAndGetStartTimeContract_isInsideTheSameStringObject_true() {
			contract.setStartTimeContract(startTimeContract);
			assertThat(contract.getStartTimeContract()).isEqualTo("testStringStartTime");
		}
		
		/**
		 * Test czy gettery i settery pola endTimeContract operuj¹ poprawnie i na tym samym obiekcie
		 */
		@Test
		public void testSetEndTimeContractAndGetEndTimeContract_isInsideTheSameStringObject_true() {
			contract.setEndTimeContract(endTimeContract);
			assertThat(contract.getEndTimeContract()).isEqualTo("testStringEndTime");
		}
		
		/**
		 * Test czy gettery i settery pola freeDay operuj¹ poprawnie i na tym samym obiekcie
		 */
		@Test
		public void testSetFreeDayAndGetFreeDay_isInsideTheSameIntValue_true() {
			contract.setFreeDay(freeDay);
			assertThat(contract.getFreeDay()).isEqualTo(1234);
		}
	}

