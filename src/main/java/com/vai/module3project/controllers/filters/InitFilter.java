package com.vai.module3project.controllers.filters;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.services.ServiceLocator;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InitFilter", value = "/init")
public class InitFilter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext appContext = request.getServletContext();
        ServiceLocator locator = ServiceLocator.getServiceLocator();
        appContext.setAttribute("serviceLocator", locator);

        User gameMaster = locator.getUserService().getUserFactory()
                .create("gm","GameMaster","gm@gmail.com","pass");
        Character gameMasterCharacter1 = locator.getCharacterService().getCharacterFactory().create("GameMaster", 50, 1000, true);
        Character gameMasterCharacter2 = locator.getCharacterService().getCharacterFactory().create("GameMasterX10", 500, 10000, true);
        long id = locator.getUserService().saveEntity(gameMaster);
        locator.getUserService().creatNewCharacter(gameMaster.getId(),gameMasterCharacter1);
        locator.getUserService().creatNewCharacter(gameMaster.getId(),gameMasterCharacter2);
        locator.getUserService().updateEntity(id,gameMaster);

        Character weakEnemy = locator.getCharacterService().getCharacterFactory().create("Местный забулдыга", 3, 75,false);
        locator.getCharacterService().saveEntity(weakEnemy);
        Character mediumEnemy = locator.getCharacterService().getCharacterFactory().create("Бабка у подъезда", 5, 100,false);
        locator.getCharacterService().saveEntity(mediumEnemy);
        Character hardEnemy = locator.getCharacterService().getCharacterFactory().create("Качек-гопник", 15, 150,false);
        locator.getCharacterService().saveEntity(hardEnemy);

        User guest = locator.getUserService().getUserFactory()
                .create("guest","Гость","guest@gmail.com","guest");
        ServiceLocator.getServiceLocator().getUserService().saveEntity(guest);

        request.getRequestDispatcher("/hello").forward(request, response);
    }
}
