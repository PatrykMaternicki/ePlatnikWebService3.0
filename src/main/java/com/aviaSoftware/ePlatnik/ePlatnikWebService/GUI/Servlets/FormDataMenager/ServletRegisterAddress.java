package com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.Servlets.FormDataMenager;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.HibernateSetup.HsqlDBSetup;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Address;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.PersonInformation;

/**
 * Servlet dla obs³ugi formularza rejestracji encji Address
 * Wczytywanie danych z formularza rejestracji dla obiektu typu Address
 * Tworzenie obiektu typu Address z danymi w polach wczytanymi z formularza
 * Przes³anie obiektu Address jako encje przez serwis DAO do bazy danych wykorzystuj¹c technologiê Hibernate
 * Przekierowanie do kolejnego formularza rejestracji
 * 
 *
 */
@WebServlet("/registerAddress")
public class ServletRegisterAddress extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String postalCode = request.getParameter("postalcode");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String flatNumber = request.getParameter("flatnumber");
		String street = request.getParameter("street");
		
	    Address address  = new Address();
	    address.setPostalCode(postalCode);
	    address.setCity(city);
	    address.setCountry(country);
	    address.setFlatNumber(Integer.parseInt(flatNumber));
	    address.setStreet(street);
	    
	   
	   HsqlDBSetup db = new HsqlDBSetup();
		em = db.createPU();
		em.getTransaction().begin();
		em.persist(address);
		em.getTransaction().commit();
		em.close();
		
		response.setContentType("text/html");
		response.sendRedirect("newRegisterEducationPage.jsp");
		
	}
}
