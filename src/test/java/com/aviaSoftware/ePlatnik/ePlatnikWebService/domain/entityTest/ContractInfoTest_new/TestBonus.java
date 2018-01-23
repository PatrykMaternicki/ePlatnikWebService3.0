package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.ContractInfoTest_new;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.Bonus;

/**
 * Testy jednostkowe klasy Bonus. 
 * Sprawdzenie czy klasa Bonus poprawnie wczytuje i zwraca nale��ce do klasy pola reprezentuj�c� typy proste 
 */
@RunWith(MockitoJUnitRunner.class)
public class TestBonus extends Mockito{

	public Bonus bonus;
	public long id;
    public String typeBonus;
    public Double value;
    public Double percentBonus;
    public String itemBonus;
	
	public TestBonus() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 *  Ustawienia inicjalizacyjne dla test�w
	 */
	@Before
	public  void setup() {
		bonus = new Bonus();
		id = 123;
		typeBonus = "testStringBonus";
		value = 1234.0;
		percentBonus = 12345.0;
		itemBonus = "testStringItem";
	}
	
	/**
	 * Test czy gettery i settery pola id operuj� poprawnie na podanej warto�ci
	 */
	@Test
	public void testSetIdsAndGetId_isInsideTheSameLongValue_true() {
		bonus.setId(id);
		assertThat(bonus.getId()).isEqualTo(123);
	}
	
	/**
	 * Test czy gettery i settery pola typeBonus operuj� poprawnie i na tym samym obiekcie
	 */
	@Test
	public void testSetTypeBonusAndGetTypeBonus_isInsideTheSameStringObject_true() {
		bonus.setTypeBonus(typeBonus);
		assertThat(bonus.getTypeBonus()).isEqualTo("testStringBonus");
	}
	
	/**
	 * Test czy gettery i settery pola value operuj� poprawnie i na tym samym obiekcie
	 */
	@Test
	public void testSetValueAndGetValue_isInsideTheSameDoubleValue_true() {
		bonus.setValue(value);
		assertThat(bonus.getValue()).isEqualTo(1234.0);
	}
	
	/**
	 * Test czy gettery i settery pola percentBonus operuj� poprawnie i na tym samym obiekcie
	 */
	@Test
	public void testSetPercentBonusAndGetPercentBonus_isInsideTheSameDoubleValue_true() {
		bonus.setPercentBonus(percentBonus);
		assertThat(bonus.getPercentBonus()).isEqualTo(12345.0);
	}
	
	/**
	 * Test czy gettery i settery pola itemBonus operuj� poprawnie i na tym samym obiekcie
	 */
	@Test
	public void testSetItemBonusAndGetItemBonus_isInsideTheSameStringObject_true() {
		bonus.setItemBonus(itemBonus);
		assertThat(bonus.getItemBonus()).isEqualTo("testStringItem");
	}
}