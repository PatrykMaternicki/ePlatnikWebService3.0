package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.DataTest.InitSystemTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.InitSystem.Setup;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.InitSystem.ModeSystem.ConfigMode;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.InitSystem.ModeSystem.iSystemMode;



@RunWith(MockitoJUnitRunner.class)
public class SetupTest extends Mockito {

	iSystemMode configMode;
	@Mock
	private Setup setup;
	
	@Before
	public void setUp(){
		configMode = new ConfigMode();
	}
	@Test
	public void when_call_getModeSystem_then_return_object_iSystemMode (){
		when(setup.getModeSystem()).thenReturn(configMode);
		assertThat("Setup doesn't return object systemMode",setup.getModeSystem(),is(iSystemMode.class));
	}
}
