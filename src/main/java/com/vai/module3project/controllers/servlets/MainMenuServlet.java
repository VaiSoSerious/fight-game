package com.vai.module3project.controllers.servlets;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.entity.Class;
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
@WebServlet(name = "mainMenu", value = "/mainmenu")
public class MainMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        log.info("Пользователь по имени " + user.getName() + " вошел в меню.");

        request.getRequestDispatcher("WEB-INF/view/mainMenu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceLocator locator = ServiceLocator.getServiceLocator();
        UserService<User> userService = locator.getUserService();
        User user = (User) request.getSession().getAttribute("user");

        String characterName = request.getParameter("delButton");
        if (characterName != null) {
            locator.getUserService().deleteCharacter(user.getId(), characterName);
        }

        String characterClass = request.getParameter("creatButton");
        String newCharacterName = request.getParameter("characterName");

        log.info("characterClass: " + characterClass + ", newCharacterName: " + newCharacterName);

        if (!userService.containsOnlyLettersAndDigits(newCharacterName)) {
            log.error("Ошибка при создании персонажа. Имя содержит не только английские буквы и цифры");
            request.setAttribute("badName", true);
            request.setAttribute("characterClass", characterClass);
            request.getRequestDispatcher("WEB-INF/view/newCharacterClass.jsp").forward(request, response);

        } else {
            if (characterClass != null) {
                Character character = null;
                switch (characterClass) {
                    case "backend" -> character = locator.getCharacterService().getCharacterFactory()
                            .create(newCharacterName, 15, 70, true, Class.BACKEND);
                    case "devops" -> character = locator.getCharacterService().getCharacterFactory()
                            .create(newCharacterName, 5, 200, true, Class.DEVOPS);
                    case "frontend" -> character = locator.getCharacterService().getCharacterFactory()
                            .create(newCharacterName, 10, 100, true, Class.FRONTEND);
                }
                locator.getUserService().creatNewCharacter(user.getId(), character);
                log.info("Создали новый персонаж с именем: " + newCharacterName + " и классом: " + characterClass
                        + "пользователю с id#: " + user.getId());
            }
            request.getRequestDispatcher("WEB-INF/view/mainMenu.jsp").forward(request, response);
        }
    }
}
