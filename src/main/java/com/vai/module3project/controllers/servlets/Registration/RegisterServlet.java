package com.vai.module3project.controllers.servlets.Registration;

import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.services.ServiceLocator;
import com.vai.module3project.model.services.UserService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "registration", value = "/registration")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("passwordRepeat");

        ServiceLocator serviceLocator = (ServiceLocator) getServletContext().getAttribute("serviceLocator");
        UserService<User> userService = serviceLocator.getUserService();

        if (!password.equals(passwordRepeat)) {
            request.setAttribute("differentPass", true);
            log.error("Ошибка при регистрации. Пароли не совпадают!.");
            request.getRequestDispatcher("WEB-INF/view/registration.jsp").forward(request, response);
            return;
        }

        if (userService.isEntityExist(login) > 0) {
            request.setAttribute("alreadyExist", true);
            log.error("Ошибка при регистрации. Пользователь с таким логином уже существует!");
            request.getRequestDispatcher("WEB-INF/view/registration.jsp").forward(request, response);
        } else if (userService.isEmailBusy(email)) {
            request.setAttribute("emailIsBusy", true);
            log.error("Ошибка при регистрации. Пользователь с такой почтой уже существует!");
            request.getRequestDispatcher("WEB-INF/view/registration.jsp").forward(request, response);
        } else {
            User user = serviceLocator.getUserService().getUserFactory().create(login, "user", email, password);
            userService.saveEntity(user);
            request.getRequestDispatcher("WEB-INF/view/welcome.jsp").forward(request, response);
        }
    }
}
