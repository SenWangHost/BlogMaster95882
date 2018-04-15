package controller;

import model.Model;

import javax.servlet.http.HttpServletRequest;

public class SearchAction extends Action{
    /**
     * the name of this action
     * @return
     */
    @Override
    public String getName() {
        return "search.do";
    }
    /**
     * the constructor of the action
     */
    public SearchAction(Model model) {

    }
    /**
     * handle the get request
     */
    @Override
    public String performGet(HttpServletRequest request) {
        return "search.jsp";
    }

    /**
     * handle the post request
     */
    @Override
    public String performPost(HttpServletRequest request) {
        return "search.jsp";
    }

}
