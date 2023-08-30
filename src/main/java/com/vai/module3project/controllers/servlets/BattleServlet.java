package com.vai.module3project.controllers.servlets;

import com.vai.module3project.model.entity.Character;
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
import java.util.Random;

@Log4j2
@WebServlet(name = "BattleServlet", value = "/battle")
public class BattleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServiceLocator locator = ServiceLocator.getServiceLocator();
        User user = (User) session.getAttribute("user");

        String selectedCharacterName = request.getParameter("fightButton");
        Character selectedCharacter = user.getCharacters().stream()
                .filter(character -> character.getName().equals(selectedCharacterName)).findFirst().get();

        Random random = new Random();
        long randomId = random.nextLong(3) + 1;

        for (Character c :locator.getCharacterService().getAllEntities()) {
            log.info(c.getName());
        }

        Character selectedEnemy = locator.getCharacterService().getEntity(randomId).get();
        log.info("Начинается бой, " + selectedCharacter.getName() + " против " + selectedEnemy.getName());

        request.setAttribute("selectedCharacter", selectedCharacter);
        request.setAttribute("selectedEnemy", selectedEnemy);
        request.getRequestDispatcher("WEB-INF/view/battle.jsp").forward(request, response);
    }
}
