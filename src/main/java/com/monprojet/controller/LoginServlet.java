package com.monprojet.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.monprojet.jdbc.Database;
import com.monprojet.jdbc.MySqlDataSource;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AuthService authService;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialisation de la base de données avec le nom de la base
        Database database = new Database(new MySqlDataSource("transportsapp"));
        authService = new AuthService(database);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String motDePass = request.getParameter("motDePass");
        System.out.println("Authentification de l'utilisateur : " + username + " avec le mot de passe : " + motDePass);

        // Vérification de l'authentification via AuthService
        boolean isAuthenticated = authService.authenticate(username, motDePass);

        if (isAuthenticated) {
            // Créer une session utilisateur et rediriger vers la page d'accueil
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            System.out.println("Context Path: " + request.getContextPath());
            response.sendRedirect(request.getContextPath() + "/views/home.jsp"); // Redirection vers home.jsp dans /views
        } else {
            // Redirection vers la page de connexion avec un message d'erreur
            response.sendRedirect("views/login.jsp?error=Invalid Credentials");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirection vers login.jsp dans le dossier /views
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }
}
