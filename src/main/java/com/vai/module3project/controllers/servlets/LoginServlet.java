package com.vai.module3project.controllers.servlets;

import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.services.CRUDService;
import com.vai.module3project.model.services.ServiceLocator;
import com.vai.module3project.model.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HelloServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("username");
        String password = request.getParameter("password");

        ServiceLocator serviceLocator = (ServiceLocator) getServletContext().getAttribute("serviceLocator");
        CRUDService<User> userService = serviceLocator.getUserService();

        if (userService.isExists(login, password)) {
            request.getRequestDispatcher("WEB-INF/view/battle.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/view/welcome.jsp").forward(request, response);
            System.out.println("не зареган");
        }
    }
}
