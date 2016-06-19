/**
 *
 */
package com.payitezy.security;

import com.payitezy.domain.Users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    /* @Autowired
     private ISellerBranchService sellerBranchService;*/

    /**
     * @param authentication
     * @return
     */
    private String determineTargetUrl(final Authentication authentication) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
            final Authentication authentication) throws IOException, ServletException {
        // super.onAuthenticationSuccess(request, response, authentication);
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        //Authentication authenticate = SecurityContextHolder.getContext().getAuthentication();
        //CustomUserDetails userDetails = (CustomUserDetails) authenticate.getPrincipal();
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // clearAuthenticationAttributes(request);
        HttpSession session = request.getSession();

        session.setAttribute("userId", user.getId());
        session.setAttribute("userName", user.getUserName());
        session.setAttribute("userType", user.getUserType());
        /*  if (user.getUserType().equals("SELLERUSER")) {
              SellerBranch sb = sellerBranchService.getSellerBranchByUserId(user.getId());
              session.setAttribute("sellerBranch", sb);
          }*/
        String targetUrl = determineTargetUrl(authentication);

        redirectStrategy.sendRedirect(request, response, targetUrl);
        // super.onAuthenticationSuccess(request, response, authentication);
    }

}
