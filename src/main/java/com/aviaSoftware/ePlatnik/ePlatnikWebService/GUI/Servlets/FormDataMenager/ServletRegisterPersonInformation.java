package com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.Servlets.FormDataMenager;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.HibernateSetup.HsqlDBSetup;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.PersonInformation;
 /**
  * Servlet dla obs³ugi formularza rejestracji encji PersonInformation
  * Wczytywanie danych z formularza rejestracji dla obiektu typu PersonInformation
  * Tworzenie obiektu typu PersonInformation z danymi w polach wczytanymi z formularza
  * Przes³anie obiektu PersonInformation jako encje przez serwis DAO do bazy danych wykorzystuj¹c technologiê Hibernate
  * Przekierowanie do kolejnego formularza rejestracji
  * 
  *
  */
@WebServlet("/registerPersonInformation")
public class ServletRegisterPersonInformation extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String dateOfBirth = request.getParameter("dateofbirth");
		String placeOfBirth = request.getParameter("placeofbirth");
		String old = request.getParameter("old");
		String pesel = request.getParameter("pesel");
		
	   PersonInformation personInformation = new PersonInformation();
	   personInformation.setName(name);
	   personInformation.setSurName(surname);
	   //Date date = new Date();
	   // personInformation.setDateOfBirth(dateOfBirth);
	   personInformation.setPlaceOfBirth(placeOfBirth);
	   personInformation.setOld((Integer.parseInt(old)));
	   personInformation.setPesel(pesel);
	   
	   HsqlDBSetup db = new HsqlDBSetup();
		em = db.createPU();
		em.getTransaction().begin();
		em.persist(personInformation);
		em.getTransaction().commit();
		em.close();
		
		response.setContentType("text/html");
		response.sendRedirect("newRegisterAddressPage.jsp");
		
	}
}
