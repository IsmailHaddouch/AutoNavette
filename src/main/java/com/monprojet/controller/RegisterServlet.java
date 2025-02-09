package com.monprojet.controller;

import com.monprojet.dao.UtilisateursDAO;
import com.monprojet.dao.UtilisateursImpl;
import com.monprojet.models.User;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String motDePass = request.getParameter("motDePass");
        // For simplicity, we assign every new registrant the "USER" role.
        String typeUser = "USER";
        
        User user = new User();
        user.setUsername(username);
        user.setMotDePasse(motDePass);
        user.setTypeUser(typeUser);
        
        UtilisateursDAO userDAO = new UtilisateursImpl();
        if (userDAO.ajouterUtilisateur(user)) {
            // Registration successful. Redirect to login page.
            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        } else {
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/register.jsp");
            rd.forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
