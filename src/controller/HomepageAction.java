package controller;

import model.Model;

import javax.servlet.http.HttpServletRequest;

public class HomepageAction extends Action {
    /**
     * This is the name of the action
     * @return
     */
    @Override
    public String getName() {
        return "homepage.do";
    }

    /**
     * The constructor for the homepage action.
     * @param model
     */
    public HomepageAction(Model model) {

    }

    /**
     *
     * @param request
     *            the request
     * @return
     */
    @Override
    public String performGet(HttpServletRequest request) {
        return "homepage.jsp";
    }

    /**
     *
     * @param request
     *            the request
     * @return
     */
    @Override
    public String performPost(HttpServletRequest request) {
        return "homepage.jsp";
    }
}
