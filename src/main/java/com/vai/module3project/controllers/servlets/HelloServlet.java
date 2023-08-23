package com.vai.module3project.controllers.servlets;

import com.vai.module3project.model.services.ServiceLocator;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "HelloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("Запуск сервера");
        ServletContext appContext = request.getServletContext();
        appContext.setAttribute("serviceLocator", ServiceLocator.getServiceLocator());

        request.getRequestDispatcher("WEB-INF/view/welcome.jsp").forward(request, response);
    }
}
