package com.vai.module3project.controllers.filters;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.services.ServiceLocator;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Log4j2
@WebFilter(filterName = "StartFilter", value = "/start")
public class StartFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.info("Запуск сервера");
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



        User guest = locator.getUserService().getUserFactory()
                .create("guest","Гость","guest@gmail.com","guest");
        ServiceLocator.getServiceLocator().getUserService().saveEntity(guest);

        request.getRequestDispatcher("/hello").forward(request, response);
    }
}
