package com.vai.module3project.controllers.servlets;

import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.services.ServiceLocator;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@Log4j2
@WebServlet(name = "mainMenu", value = "/mainmenu")
public class MainMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        log.info("Пользователь по имени " + user.getName() + " вошел в меню.");

        ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
        if (serviceLocator.getUserService().userHaveCharactersCheck(user.getId())) {
            request.setAttribute("userHaveCharactersCheck", true);
        } else {
            request.setAttribute("userHaveCharactersCheck", false);
        }


        request.getRequestDispatcher("WEB-INF/view/mainMenu.jsp").forward(request, response);
    }
}
