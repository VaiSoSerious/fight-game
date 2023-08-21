package com.vai.module3project.controllers.filters;

import com.vai.module3project.model.factories.EnemyCharacterServiceFactory;
import com.vai.module3project.model.factories.ServiceFactory;
import com.vai.module3project.model.factories.UserServiceFactory;
import com.vai.module3project.model.services.ServiceLocator;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "StartFilter", value = "/start")
public class StartFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.getRequestDispatcher("/hello").forward(request, response);
    }
}
