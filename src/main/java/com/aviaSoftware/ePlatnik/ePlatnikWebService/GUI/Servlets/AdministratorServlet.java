package com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.Servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/administrator")
public class AdministratorServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		session.setAttribute("userType", "administrator");
		response.sendRedirect("login.jsp");
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
	}
}
