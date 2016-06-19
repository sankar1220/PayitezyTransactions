package com.payitezy.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    private String errorPage;

    public MyAccessDeniedHandler() {
    }

    public MyAccessDeniedHandler(final String errorPage) {
        this.errorPage = errorPage;
    }

    public String getErrorPage() {
        return errorPage;
    }

    @Override
    public void handle(final HttpServletRequest request, final HttpServletResponse response,
            final AccessDeniedException accessDeniedException) throws IOException, ServletException {

        //do some business logic, then redirect to errorPage url
        response.sendRedirect(errorPage);

    }

    public void setErrorPage(final String errorPage) {
        this.errorPage = errorPage;
    }

}