package com.vai.module3project.controllers.servlets;

import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.services.ServiceLocator;
import com.vai.module3project.model.services.UserService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
        UserService<User> userService = serviceLocator.getUserService();

        String login = "guest";
        long userId = userService.isEntityExist(login);
        if (userId > 0) {
            HttpSession session = request.getSession();
            User user = serviceLocator.getUserService().getEntity(userId).get();
            log.info(user);
            session.setAttribute("user",user);
            log.info("Был произведен вход в систему как гость.");
            response.sendRedirect("/mainmenu");
        } else {
            log.error("Попытка входа как гость не удалась. Пользователь не найден.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guest = request.getParameter("guestButton");
        log.info(guest);
        String login = request.getParameter("username");
        String password = request.getParameter("password");

        ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
        UserService<User> userService = serviceLocator.getUserService();

        long userId = userService.isEntityExist(login);
        if (userId > 0) {
            if (userService.isCorrectPassword(password, userId)) {
                HttpSession session = request.getSession();
                User user = serviceLocator.getUserService().getEntity(userId).get();
                session.setAttribute("user",user);
                log.info("Был произведен вход в систему.");
                response.sendRedirect("/mainmenu");
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
