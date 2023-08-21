package com.vai.module3project.controllers.servlets.Registration;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.services.CRUDService;
import com.vai.module3project.model.services.ServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("username");
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");


        Character player = new Character(true, 100, 5, nickname);
        User user = new User(0L,login,password,player);

        ServiceLocator serviceLocator = (ServiceLocator) getServletContext().getAttribute("serviceLocator");
        CRUDService<User> userService = serviceLocator.getUserService();
        userService.creat(user);

        System.out.println("сохранили: " + user);

        System.out.println("user1: " + userService.get(1));
        System.out.println("user2: " + userService.get(2));
        System.out.println("user3: " + userService.get(3));
        System.out.println("user4: " + userService.get(4));
        System.out.println("user5: " + userService.get(5));
        System.out.println("user6: " + userService.get(6));

        request.getRequestDispatcher("WEB-INF/view/welcome.jsp").forward(request, response);
    }
}
