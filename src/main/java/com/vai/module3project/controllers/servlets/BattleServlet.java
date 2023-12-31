package com.vai.module3project.controllers.servlets;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.entity.FightCalculator;
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
import java.util.Date;
import java.util.Random;

@Log4j2
@WebServlet(name = "BattleServlet", value = "/battle")
public class BattleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("selectedCharacter");
        session.removeAttribute("selectedEnemy");
        ServiceLocator locator = ServiceLocator.getServiceLocator();
        User user = (User) session.getAttribute("user");

        String selectedCharacterName = request.getParameter("fightButton");
        if (selectedCharacterName != null) {
            Character selectedCharacter = user.getCharacters().stream()
                    .filter(character -> character.getName().equals(selectedCharacterName)).findFirst().get();

            Random random = new Random();
            long randomId = random.nextLong(3) + 1;

            Character selectedEnemy = locator.getCharacterService().getEntity(randomId).get().clone();
            log.info("Начинается бой, " + selectedCharacter.getName() + " против " + selectedEnemy.getName());
            session.setAttribute("selectedCharacter", selectedCharacter);
            session.setAttribute("selectedEnemy", selectedEnemy);
        }
        request.getRequestDispatcher("WEB-INF/view/battle.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean gameIsOver = false;
        HttpSession session = request.getSession();
        Character selectedCharacter = (Character) session.getAttribute("selectedCharacter");
        Character selectedEnemy = (Character) session.getAttribute("selectedEnemy");

        log.info(selectedCharacter);

        String hit = request.getParameter("hitButton");
        if (hit != null && hit.equals("hit")) {
//            if (selectedCharacter.isTurn()) {
            FightCalculator.hit(selectedCharacter, selectedEnemy);
            selectedEnemy.setHealth(FightCalculator.getDefensiveCharacterHealth());
            request.setAttribute("playerHitText", FightCalculator.getAttackingCharacterHitText());


//            Date date = new Date();
//            while (date.getTime() < (date.getTime() + 1000)) {
//
//            }
            FightCalculator.hit(selectedEnemy, selectedCharacter);
            selectedCharacter.setHealth(FightCalculator.getDefensiveCharacterHealth());
            request.setAttribute("enemyHitText", FightCalculator.getAttackingCharacterHitText());

//            int selectedCharacterDamage = selectedCharacter.getCharacterClass().getPower();
//            int selectedEnemyHealth = selectedEnemy.getHealth();
//
//            String selectedCharacterHitText = selectedCharacter.getCharacterClass().getHit();
//            selectedEnemy.setHealth(selectedEnemyHealth - selectedCharacterDamage);
//            request.setAttribute("selectedCharacterDamage", selectedCharacterDamage);
//            request.setAttribute("selectedEnemyHealth", selectedEnemyHealth);

        }
        if (selectedEnemy.getHealth() <= 0) {
            gameIsOver = true;
            Boolean s = (Boolean) request.getAttribute("enemyLost");
            log.info(s);
            selectedEnemy.setHealth(0);
            selectedCharacter.increasePercents(selectedEnemy.getCharacterClass().getExperience());
            request.setAttribute("enemyLost", gameIsOver);
        } else if (selectedCharacter.getHealth() <= 0) {
            gameIsOver = true;
            selectedCharacter.setHealth(0);
            request.setAttribute("playerLost", gameIsOver);
        }

        request.getRequestDispatcher("WEB-INF/view/battle.jsp").forward(request, response);
        if (gameIsOver) {
            selectedCharacter.setHealth(selectedCharacter.getCharacterClass().getHealth());
        }
    }
}
