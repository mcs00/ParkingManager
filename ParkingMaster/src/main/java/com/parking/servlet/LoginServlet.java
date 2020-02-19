package com.parking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parking.dto.User;
import com.parking.service.AutheticationService;

@WebServlet("/action-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("usuName");
		String userPass = request.getParameter("usuPass");
		AutheticationService servei = new AutheticationService();
		boolean isAuthenticate = servei.validUser(userId, userPass);
		

		if (isAuthenticate) {
			System.out.println("usuario:"+userId); 
			
	
			User usuari = servei.getUsuari(userId);			
			request.getSession().setAttribute("user", usuari);			
			response.sendRedirect("login/user-greeting.jsp");
			
		}else {
			response.sendRedirect("login/user-login.jsp");
		}

	}

}