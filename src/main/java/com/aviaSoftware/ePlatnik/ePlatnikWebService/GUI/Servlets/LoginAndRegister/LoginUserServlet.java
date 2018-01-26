package com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.Servlets.LoginAndRegister;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginuser")
public class LoginUserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("newLoginPage.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	}
}
