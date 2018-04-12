package controller;

import databean.User;
import formbean.RegisterForm;
import model.Model;
import model.UserDAO;
import org.genericdao.RollbackException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class RegisterAction extends Action {
    private UserDAO userDAO;
    /**
     * the get name method for register action.
     * @return
     */
    @Override
    public String getName() {
        return "register.do";
    }

    /**
     * The constructor for register action
     * @param model
     */
    public RegisterAction(Model model) {
        userDAO = model.getUserDAO();
    }

    /**
     * Handle the get request.
     * @param request
     *            the request
     * @return
     */
    @Override
    public String performGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "homepage.do";
        }
        return "register.jsp";
    }

    /**
     * Handle the post request
     * @param request
     *            the request
     * @return
     */
    @Override
    public String performPost(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "homepage.do";
        }
        List<String> errors = new ArrayList<>();
        request.setAttribute("errors", errors);
        RegisterForm registerForm = new RegisterForm(request);
        request.setAttribute("form", registerForm);
        errors.addAll(registerForm.getValidationErrors());
        if (errors.size() > 0) {
            return "register.jsp";
        }
        // create a new user
        User user = new User();
        user.setEmail(registerForm.getEmail());
        user.setPassword(registerForm.getPassword1());
        user.setFirstname(registerForm.getFirstname());
        user.setLastname(registerForm.getLastname());
        try {
            userDAO.create(user);
            session.setAttribute("user", user);
            return "homepage.do";
        } catch (RollbackException e) {
            e.printStackTrace();
            return "errors.jsp";
        }
    }
}
