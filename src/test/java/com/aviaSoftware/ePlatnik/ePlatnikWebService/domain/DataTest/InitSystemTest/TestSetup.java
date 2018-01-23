package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.DataTest.InitSystemTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.InitSystem.Setup;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.InitSystem.ModeSystem.DevelopmentMode;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.InitSystem.ModeSystem.iSystemMode;


/**
 * Testy jednostkowe klasy Setup. 
 * Sprawdzenie czy klasa Setup poprawnie generuje obiekty modeluj¹ce tryb pracy systemu 
 */
@RunWith(MockitoJUnitRunner.class)
public class TestSetup extends Mockito {

	@Mock
	public iSystemMode developmentMode;
	
	@InjectMocks
	public Setup setup;
		
	public TestSetup() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Mock dla klas zale¿nych od klasy Setup
	 * 
	 */
	@Before
	public void setup(){
		setup = new Setup();
		developmentMode = mock(DevelopmentMode.class);
	}
	
	/**
	 * Test czy metody changeMode(iSystemMode systemMode) i getModeSystem() operuj¹ na tym samym obiekcie
	 */
	@Test
	public void when_call_getModeSystem_then_return_object_iSystemMode (){
		when(developmentMode.isDisableAdministratorUI()).thenReturn(false);
		setup.changeMode(developmentMode);
		assertThat(setup.getModeSystem().isDisableAdministratorUI()).isFalse();
	}
	

}
