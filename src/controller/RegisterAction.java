package controller;

import model.Model;
import model.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

        return "register.jsp";
    }
}
