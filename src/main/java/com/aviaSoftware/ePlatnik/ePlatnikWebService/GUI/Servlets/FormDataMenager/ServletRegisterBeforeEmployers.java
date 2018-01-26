package com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.Servlets.FormDataMenager;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.HibernateSetup.HsqlDBSetup;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.BeforeEmployers;

/**
 * Servlet dla obs³ugi formularza rejestracji encji BeforeEmployers
 * Wczytywanie danych z formularza rejestracji dla obiektu typu BeforeEmployers
 * Tworzenie obiektu typu BeforeEmployers z danymi w polach wczytanymi z formularza
 * Przes³anie obiektu BeforeEmployers jako encje przez serwis DAO do bazy danych wykorzystuj¹c technologiê Hibernate
 * Przekierowanie do kolejnego formularza rejestracji
 * 
 *
 */
@WebServlet("/registerBeforeEmployers")
public class ServletRegisterBeforeEmployers extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String nameEmployers = request.getParameter("nameemployers");
		String startYearWork = request.getParameter("startyearwork");
		String endYearWork = request.getParameter("endyearwork");
		String endMonthWork = request.getParameter("endmonthwork");
		String startMonthWork = request.getParameter("startmonthwork");
		
	    BeforeEmployers beforeEmployers = new BeforeEmployers();
	    beforeEmployers.setNameEmployers(nameEmployers);
	    beforeEmployers.setStartYearWork(Integer.parseInt(startYearWork));
	    beforeEmployers.setEndYearWork(Integer.parseInt(endYearWork));
	    beforeEmployers.setEndMonthWork(Integer.parseInt(endMonthWork));
	    beforeEmployers.setStartMonthWork(Integer.parseInt(startMonthWork));

	    
	   HsqlDBSetup db = new HsqlDBSetup();
		em = db.createPU();
		em.getTransaction().begin();
		em.persist(beforeEmployers);
		em.getTransaction().commit();
		em.close();
	
		
		response.setContentType("text/html");
		response.sendRedirect("newRegisterCoursePage.jsp");
		
	}
}
