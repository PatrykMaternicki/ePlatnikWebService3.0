package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.PersonInfoTest;

		import java.text.ParseException;
		import java.text.SimpleDateFormat;
		import java.util.Date;

		import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Person;
		import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Setups.HibernateSetup;
		import org.junit.Before;
		import org.junit.Test;

		import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.PersonInformation;

		import javax.persistence.EntityManager;

		import static org.junit.Assert.*;
		import static org.hamcrest.CoreMatchers.*;

public class PersonInformationTest extends HibernateSetup {

	private PersonInformation personInformation;
	private PersonInformation entity;
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
		super.createPU();
		EntityManager em = super.getEm();
		em.getTransaction().begin();
		em.persist(personInformation);
		em.getTransaction().commit();
		entity = em.find(PersonInformation.class,personInformation.getId());
		em.close();

	}
	@Test
	public void should_be_date_is_date(){
		assertThat("Field dateOfBirth in PersonInformation is not Date", personInformation.getDateOfBirth(), is(Date.class));
	}
	@Test
	public void testPU_should_be_return_date(){
		assertEquals("Column dateOfBirth in entity PERSON_INFORMATION is not equal dateOfBirth in personInformation Object",
				personInformation.getDateOfBirth(),
				entity.getDateOfBirth()
		);
	}
	@Test
	public void should_be_name_is_string(){
		assertThat("Field name in PersonInformation is not String", personInformation.getName(), is(String.class));
	}
	@Test
	public void testPU_should_be_return_name(){
		assertEquals("Column name in entity PERSON_INFORMATION is not equal name in personInformation Object",
				personInformation.getName(),
				entity.getName()
		);
	}
	@Test
	public void should_be_old_is_integer(){
		assertThat("Field Old in PersonInformation is not integer", personInformation.getOld(), is(Integer.class));

	}
	@Test
	public void testPU_should_be_return_old(){
		assertEquals("Column old in entity PERSON_INFORMATION is not equal old in personInformation Object",
				personInformation.getOld(),
				entity.getOld()
		);
	}
	@Test
	public void should_be_pesel_is_string(){
		assertThat("Field Pesel in PersonInformation is not String", personInformation.getPesel(), is(String.class));
	}
	@Test
	public void testPU_should_be_return_pesel(){
		assertEquals("Column pesel in entity PERSON_INFORMATION is not equal pesel in personInformation Object",
				personInformation.getPesel(),
				entity.getPesel()
		);
	}
	@Test
	public void should_be_placeofbirth_is_string(){
		assertThat("Field placeOfBirth in PersonInformation is not String", personInformation.getPlaceOfBirth(), is(String.class));

	}
	@Test
	public void testPU_should_be_return_placeOfBirth(){
		assertEquals("Column placeOfBirth in entity PERSON_INFORMATION is not equal placeOfBirth in personInformation Object",
				personInformation.getPlaceOfBirth(),
				entity.getPlaceOfBirth()
		);
	}
	@Test
	public void should_be_surname_is_string(){
		assertThat("Field surname in PersonInformation is not String", personInformation.getSurName(), is(String.class));

	}
	@Test
	public void testPU_should_be_return_surname(){
		assertEquals("Column surname in entity PERSON_INFORMATION is not equal surname in personInformation Object",
				personInformation.getPlaceOfBirth(),
				entity.getPlaceOfBirth()
		);
	}

}