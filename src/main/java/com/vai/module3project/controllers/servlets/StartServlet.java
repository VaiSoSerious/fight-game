package com.vai.module3project.controllers.servlets;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.entity.FightCalculator;

import java.io.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "StartServlet", value = "/w")
public class StartServlet extends HttpServlet {
    private Character player;
    private Character enemy;
    String message;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        try (PrintWriter out = response.getWriter()) {

            if (player == null) {
                player = new Character(true, 100, 30, "Peppa");
                session.setAttribute("player", player);
                enemy = new Character(false, 85, 30, "Enemy");
                session.setAttribute("enemy", enemy);


                message = "Player " + player.getName() + " vs " + enemy.getName() + ". The battle begins!";
                out.println("<html><body>");
                out.println("<h1>" + message + "</h1>");
                out.println("</body></html>");
            } else {
                switch (FightCalculator.gameIsOverCheck(player.getHealth(), enemy.getHealth())) {
                    case 1 -> out.println("DRAW!");
                    case 2 -> out.printf("%s won!", player.getName());
                    case 3 -> out.printf("%s won!", enemy.getName());
                    default -> {
                        if (player.isTurn()) {
                            enemy.setHealth(enemy.getHealth() - player.hit());
                            enemy.setHealth(FightCalculator.healthCheck(enemy.getHealth()));
                            player.setTurn(false);


                            out.printf("The %s dealt: %d damage to an %s.\n %s has %d hit points left", player.getName(),
                                    player.hit(), enemy.getName(), enemy.getName(), enemy.getHealth());
                        } else {
                            player.setHealth(player.getHealth() - enemy.hit());
                            player.setHealth(FightCalculator.healthCheck(player.getHealth()));
                            player.setTurn(true);


                            out.printf("The %s dealt: %d damage to an %s.\n %s has %d hit points left", enemy.getName(),
                                    enemy.hit(), player.getName(), player.getName(), player.getHealth());
                        }
                    }
                }
            }
        }
    }

    public void destroy() {
    }
}