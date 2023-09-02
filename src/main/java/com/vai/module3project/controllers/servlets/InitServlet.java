package com.vai.module3project.controllers.servlets;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.entity.Class;
import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.services.ServiceLocator;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InitServlet", value = "/init")
public class InitServlet extends HttpServlet {
    boolean isInit = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       Код сервлета запускается два раза, сделал проверку, чтоб не было повторения выполнения
        if (!isInit) {
            isInit = initialization();
        }
        response.sendRedirect("/hello");
    }

    private boolean initialization() {
        ServiceLocator locator = ServiceLocator.getServiceLocator();
        User gameMaster = locator.getUserService().getUserFactory()
                .create("gm", "GameMaster", "gm@gmail.com", "pass");
        Character gameMasterCharacter1 = locator.getCharacterService().getCharacterFactory().create("GameMasterX1", 50, true, Class.ADMIN);
        Character gameMasterCharacter2 = locator.getCharacterService().getCharacterFactory().create("GameMasterX10", 500, true, Class.ADMIN);
        long id = locator.getUserService().saveEntity(gameMaster);
        locator.getUserService().creatNewCharacter(gameMaster.getId(), gameMasterCharacter1);
        locator.getUserService().creatNewCharacter(gameMaster.getId(), gameMasterCharacter2);
        locator.getUserService().updateEntity(id, gameMaster);

        Character weakEnemy = locator.getCharacterService().getCharacterFactory().create("Петруха",  75, false, Class.LOCALBASTARD);
        locator.getCharacterService().saveEntity(weakEnemy);
        Character mediumEnemy = locator.getCharacterService().getCharacterFactory().create("Тамара Петровна", 100, false, Class.GRANDMAATTHEDOOR);
        locator.getCharacterService().saveEntity(mediumEnemy);
        Character hardEnemy = locator.getCharacterService().getCharacterFactory().create("Валерий",  150, false, Class.YOBJOCK);
        locator.getCharacterService().saveEntity(hardEnemy);

        User guest = locator.getUserService().getUserFactory()
                .create("guest", "Гость", "guest@gmail.com", "guest");
        ServiceLocator.getServiceLocator().getUserService().saveEntity(guest);
        return true;
    }
}
