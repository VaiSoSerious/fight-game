package com.vai.module3project.controllers.filters;

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
