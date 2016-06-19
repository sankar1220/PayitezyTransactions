package com.payitezy.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private RedirectStrategy redirect = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response,
            final AuthenticationException exception) throws IOException, ServletException {
        // TODO Auto-generated method stub
        if (request.getParameter("channel") != null) {
            //response.sendError(401);
            response.setStatus(401);
        }
        else {
            response.setStatus(200);
            super.onAuthenticationFailure(request, response, exception);
        }
        /*if(request.getParameter("channel")=="mobile"){
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }*/
        /*		else{*/
        //super.onAuthenticationFailure(request, response, exception);
        /*}*/

    }

}
