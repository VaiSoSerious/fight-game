package com.vai.module3project.controllers.servlets;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "CreatCharacterClassServlet", value = "/creatcharacter")
public class CreatCharacterClassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String characterClass = request.getParameter("class");
        log.info("Пользователь выбрал: " + characterClass);
        request.setAttribute("characterClass",characterClass);
        request.getRequestDispatcher("/WEB-INF/view/newCharacterClass.jsp").forward(request, response);
    }
}
