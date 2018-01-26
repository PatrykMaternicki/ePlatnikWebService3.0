package com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.Servlets.LoginAndRegister;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registeruser")
public class RegisterUserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("newRegisterPage.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	}
}
