package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.PersonInfoTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.PersonInformation;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PersonInformationTest {
	
	private PersonInformation personInformation;
	@Before
	public void setUp() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "22-01-2015 10:20:56";
		Date date = sdf.parse(dateInString);
		personInformation = new PersonInformation();
		personInformation.setDateOfBirth(date);
		personInformation.setName("Patryk");
		personInformation.setOld(25);
		personInformation.setPesel("020202");
		personInformation.setPlaceOfBirth("Gdansk");
		personInformation.setSurName("Maternicki");
	}
	@Test
	public void should_be_date_is_date(){
		assertThat("Field dateOfBirth in PersonInformation is not Date", personInformation.getDateOfBirth(), is(Date.class));
	}
	@Test
	public void should_be_name_is_string(){
		assertThat("Field name in PersonInformation is not String", personInformation.getName(), is(String.class));
		
	}
	@Test
	public void should_be_old_is_integer(){
		assertThat("Field Old in PersonInformation is not integer", personInformation.getOld(), is(Integer.class));

	}
	@Test
	public void should_be_pesel_is_string(){
		assertThat("Field Pesel in PersonInformation is not String", personInformation.getPesel(), is(String.class));

	}
	@Test
	public void should_be_placeofbirth_is_string(){
		assertThat("Field placeOfBirth in PersonInformation is not String", personInformation.getPlaceOfBirth(), is(String.class));

	}
	@Test
	public void should_be_surname_is_string(){
		assertThat("Field surname in PersonInformation is not String", personInformation.getSurName(), is(String.class));

	}
	
	
}
