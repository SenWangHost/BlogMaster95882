package controller;

import model.Model;

import javax.servlet.http.HttpServletRequest;

public class LoginAction extends Action {
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

    }
    /**
     * handle the http get method
     */
    @Override
    public String performGet(HttpServletRequest request) {
        return "login.jsp";
    }

    @Override
    public String performPost(HttpServletRequest request) {
        return "login.jsp";
    }

}
