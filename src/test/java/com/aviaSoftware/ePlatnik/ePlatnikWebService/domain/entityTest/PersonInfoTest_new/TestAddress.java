package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.PersonInfoTest_new;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Address;

/**
 * Testy jednostkowe klasy Address. 
 * Sprawdzenie czy klasa Address poprawnie wczytuje i zwraca zale�ne od niej pola reprezentuj�c� typy proste  
 */
@RunWith(MockitoJUnitRunner.class)
public class TestAddress extends Mockito{

		public Address address;
	    public Long id;
	    public String postalCode;
	    public String city;
	    public String country;
	    public int flatNumber;
	    public String street;
	    
	    public TestAddress() {
			MockitoAnnotations.initMocks(this);
		}
	    
	    /**
		 *  Ustawienia inicjalizacyjne dla test�w
		 */
		@Before
		public  void setup() {
			address = new Address();
			id = 123l;
			postalCode = "testStringPostalCode";
			city = "testStringCity";
			country = "testStringCountry";
			flatNumber = 1234;
			street = "testStringStreet";
		}
		
		/**
		 * Test czy gettery i settery pola id operuj� poprawnie na podanej warto�ci
		 */
		@Test
		public void testSetIdsAndGetId_isInsideTheSameLongValue_true() {
			address.setId(id);
			assertThat(address.getId()).isEqualTo(123);
		}
		
		/**
		 * Test czy gettery i settery pola postalCode operuj� poprawnie na podanej warto�ci
		 */
		@Test
		public void testSetPostalCodeAndGetPostalCode_isInsideTheSameStringObject_true() {
			address.setPostalCode(postalCode);
			assertThat(address.getPostalCode()).isEqualTo("testStringPostalCode");
		}
		
		/**
		 * Test czy gettery i settery pola city operuj� poprawnie na podanej warto�ci
		 */
		@Test
		public void testSetCitytAndGetCity_isInsideTheSameStringObject_true() {
			address.setCity(city);
			assertThat(address.getCity()).isEqualTo("testStringCity");
		}
		
		/**
		 * Test czy gettery i settery pola country operuj� poprawnie na podanej warto�ci
		 */
		@Test
		public void testSetCountrytAndGetCountry_isInsideTheSameStringObject_true() {
			address.setCountry(country);
			assertThat(address.getCountry()).isEqualTo("testStringCountry");
		}
	
		/**
		 * Test czy gettery i settery pola id operuj� poprawnie na podanej warto�ci
		 */
		@Test
		public void testSetFlatNumberAndGetFlatNumber_isInsideTheSameIntValue_true() {
			address.setFlatNumber(flatNumber);
			assertThat(address.getFlatNumber()).isEqualTo(1234);
		}
		
		/**
		 * Test czy gettery i settery pola street operuj� poprawnie na podanej warto�ci
		 */
		@Test
		public void testSetStreetAndGetStreet_isInsideTheSameStringObject_true() {
			address.setStreet(street);
			assertThat(address.getStreet()).isEqualTo("testStringStreet");
		}
}
