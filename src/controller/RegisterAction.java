package controller;

import model.Model;

import javax.servlet.http.HttpServletRequest;

public class RegisterAction extends Action {
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

    }

    /**
     * Handle the get request.
     * @param request
     *            the request
     * @return
     */
    @Override
    public String performGet(HttpServletRequest request) {
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
        return "register.jsp";
    }
}
