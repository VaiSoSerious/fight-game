package com.vai.module3project.controllers.servlets;

import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.services.CRUDService;
import com.vai.module3project.model.services.ServiceLocator;
import com.vai.module3project.model.services.UserService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet("/LoginServlet")
public class LoginServlet extends HelloServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("username");
        String password = request.getParameter("password");

        ServiceLocator serviceLocator = (ServiceLocator) getServletContext().getAttribute("serviceLocator");
        UserService<User> userService = serviceLocator.getUserService();

        long userId = userService.isEntityExist(login);
        if (userId > 0) {
            if (userService.isCorrectPassword(password, userId)) {
                request.getRequestDispatcher("WEB-INF/view/battle.jsp").forward(request, response);
                log.info("Был произведен вход в систему.");
            } else {
                request.setAttribute("wrongPass", true);
                request.getRequestDispatcher("WEB-INF/view/welcome.jsp").forward(request, response);
                log.error("При попытке входа возникла ошибка: не верный пароль!");
            }
        } else {
            request.setAttribute("isExist", true);
            request.getRequestDispatcher("WEB-INF/view/welcome.jsp").forward(request, response);
            log.error("При попытке входа возникла ошибка: пользователь не найден!");
        }
    }
}
