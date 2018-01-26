package com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.Servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.jsp")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private String user;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		user = session.getAttribute("userType").toString();
		response.setContentType("text/html");
		response.getWriter().println("<h1>Serwis webowy systemu <strong><i>ePlatnik</i></strong><br /></h1>");
		response.getWriter().println("<h2>Logowanie/rejestracja do grupy uzytkowników: <strong><i>" + user + "</i></strong><br /></h2>");
		response.getWriter().println("<form action=loginuser method=get><label><input type=submit value=logowanie /><label></form><br /><br />");
		response.getWriter().println("<form action=registeruser method=get><label><input type=submit value=rejestracja /><label></form>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	}
}
