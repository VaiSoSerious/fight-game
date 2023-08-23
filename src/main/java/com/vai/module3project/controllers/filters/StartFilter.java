package com.vai.module3project.controllers.filters;

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

        request.getRequestDispatcher("/init").forward(request, response);
    }
}
