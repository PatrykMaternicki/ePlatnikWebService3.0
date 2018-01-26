package com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.Servlets.FormDataMenager;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.HibernateSetup.HsqlDBSetup;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Education;

/**
 * Servlet dla obs³ugi formularza rejestracji encji Education
 * Wczytywanie danych z formularza rejestracji dla obiektu typu Education
 * Tworzenie obiektu typu Education z danymi w polach wczytanymi z formularza
 * Przes³anie obiektu Education jako encje przez serwis DAO do bazy danych wykorzystuj¹c technologiê Hibernate
 * Przekierowanie do kolejnego formularza rejestracji
 * 
 *
 */
@WebServlet("/registerEducation")
public class ServletRegisterEducation extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String nameSchool = request.getParameter("nameschool");
		String startYear = request.getParameter("startyear");
		String endYear = request.getParameter("endyear");
		
	    Education education = new Education();
	    education.setNameSchool(nameSchool);
	    education.setStartYear(Integer.parseInt(startYear));
	    education.setStartYear(Integer.parseInt(endYear));

	   HsqlDBSetup db = new HsqlDBSetup();
		em = db.createPU();
		em.getTransaction().begin();
		em.persist(education);
		em.getTransaction().commit();
		em.close();
	
		
		response.setContentType("text/html");
		response.sendRedirect("newRegisterBeforeEmployers.jsp");
		
	}
}
