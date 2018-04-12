package controller;

import formbean.LoginForm;
import model.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutAction extends Action {
    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "logout.do";
    }
    /**
     * the constructor
     */
    public LogoutAction(Model model) {

    }
    /**
     * Handle HTTP GET request.
     * @request http servlet request
     */
    @Override
    public String performGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "login.do";
        }
        // Otherwise, just display the login page.
        session.setAttribute("user", null);
        return "login.do";
    }

    /**
     * Handle HTTP POST request.
     * @request http servlet request
     */
    @Override
    public String performPost(HttpServletRequest request) {
        return performGet(request);
    }

}
