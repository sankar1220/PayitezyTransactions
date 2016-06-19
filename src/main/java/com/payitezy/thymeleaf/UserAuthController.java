package com.payitezy.thymeleaf;

import com.payitezy.dao.RolesRepository;
import com.payitezy.dao.UsersRepository;
import com.payitezy.domain.Roles;
import com.payitezy.domain.Users;
import com.payitezy.service.IUsersService;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
@PropertySource("classpath:application.properties")
public class UserAuthController {

    @Value("${url}")
    private String url;
    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private IUsersService userService;
    @Autowired
    @Qualifier("authenticationManager")
    AuthenticationManager authenticationManager;

    @Autowired
    private RolesRepository rolesRepository;

    /*
    @Autowired
    private RoleRepository roleRepository;
    String restaurant = "ROLE_RESTAURANT";
    @Autowired
    private IRestaurantBranchService restaurantBranchService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private ISubOrderService subOrderService;
    @Autowired
    private IRestaurantService restaurantService;
    @Autowired
    private IPreOrderCartItemsService preOrderCartItemsService;
     */
    @RequestMapping(value = "/denied")
    public String denied(final HttpServletRequest request, final HttpServletResponse res, final HttpSession session,
            final BindingResult result, final ModelMap model) throws IOException {

        session.invalidate();
        model.addAttribute("title", "Hello world!");
        model.addAttribute("messageType", "Failure");
        return "denied";
    }

    @RequestMapping(value = "/auth/login/failure")
    public String loginauthSessionFailure(final HttpServletRequest request, final HttpServletResponse res, final HttpSession session,
            final BindingResult result, final ModelMap model) throws IOException {
        /*model.addAttribute("message", message);
        return "access/login";*/
        session.invalidate();
        String message = "Session Login Failure!";
        model.addAttribute("message", message);
        model.addAttribute("messageType", "Failure");
        //model.addAttribute("message", res);
        //System.out.println("session new"+session.isNew());
        // return "index";
        return "redirect:" + url + "/login";

        /*String message = " Session Login Failure!";
        return "redirect:/login?message="+message;*/
    }

    @RequestMapping(value = "/login/failure")
    public String loginFailure(final HttpServletRequest request, final HttpServletResponse res, final BindingResult result,
            HttpSession session, final ModelMap model) throws IOException {
        session = request.getSession(false);
        String message = null;
        try {
            session.invalidate();
            message = "Entered UserName or Password is Wrong";
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:" + url + "/login";
    }

    @RequestMapping(value = "/auth/maxSession")
    public String loginFailureMaxSessions(final HttpServletRequest request, final HttpServletResponse res, final BindingResult result,
            final ModelMap model) throws IOException {
        // session.invalidate();
        HttpSession session = request.getSession(false);
        model.addAttribute("message", "login max seesions exceed failure");
        model.addAttribute("messageType", "Failure");

        return "index";

    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET, consumes = { MediaType.ALL_VALUE })
    public String loginUser(final HttpServletRequest request, final HttpServletResponse res, final HttpSession session,
            final BindingResult result, final ModelMap model) throws IOException {

        // String username2 = request.getParameter("reurl");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = request.getParameter(authentication.getName());
        session.setAttribute("username", username);
        for (GrantedAuthority s : authentication.getAuthorities()) {
        }
        String username1 = null;
        String userId = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof Users) {
            username1 = ((Users) principal).getUserName();
            userId = ((Users) principal).getId();
        }
        else {
            username1 = principal.toString();
        }
        String role = null;

        if (userId != null) {

            List<Roles> rs = rolesRepository.getByUsers(userId);
            for (Roles r : rs) {
                role = r.getRoleName();

            }
            session.setAttribute("userName", username1);
            session.setAttribute("userId", userId);
            session.setMaxInactiveInterval(24 * 60 * 60);

            model.addAttribute("auth", authentication);
            model.addAttribute("session1", session);
            model.addAttribute("message", "User SuccessFully LoggedIN!");

            return "/index";
        }

        else {
            session.invalidate();
            model.addAttribute("message", "user session was logged out! Please Login");
            model.addAttribute("messageType", "Failure");

            return "redirect:" + url + "/login";
        }

    }

    @RequestMapping(value = "/logout/success")
    public String logoutSuccess(final HttpServletRequest request, final HttpServletResponse res, final HttpSession session,
            final BindingResult result, final ModelMap model) throws IOException {
        String message = "Logout Success!";
        session.invalidate();
        model.addAttribute("message", message);
        model.addAttribute("messageType", "Failure");

        return "index";
    }

}