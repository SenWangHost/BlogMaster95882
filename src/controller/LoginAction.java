package controller;

import databean.User;
import formbean.LoginForm;
import model.Model;
import model.UserDAO;
import org.genericdao.RollbackException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class LoginAction extends Action {
    private UserDAO userDAO;
    /**
     * the name of the action
     * @return
     */
    @Override
    public String getName() {
        return "login.do";
    }
    /**
     * the constructor for LoginAction
     */
    public LoginAction(Model model) {
        userDAO = model.getUserDAO();
    }
    /**
     * handle the http get method
     */
    @Override
    public String performGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "homepage.do";
        }
        return "login.jsp";
    }

    @Override
    public String performPost(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "homepage.do";
        }
        try {
            List<String> errors = new ArrayList<String>();
            request.setAttribute("errors", errors);
            LoginForm loginForm = new LoginForm(request);
            errors.addAll(loginForm.getValidationErrors());
            if (errors.size() > 0) {
                return "login.jsp";
            }
            User user = userDAO.read(loginForm.getEmail());
            if (user == null) {

            }
        } catch (RollbackException e) {
            e.printStackTrace();
        }
        return "login.jsp";
    }

}
