package controller;

import databean.User;
import formbean.LoginForm;
import model.Model;
import org.genericdao.RollbackException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class MyBlogsAction extends Action {
    /**
     * the name of the action.
     * @return
     */
    @Override
    public String getName() {
        return "myblogs.do";
    }
    /**
     * the constructor for action
     */
    public MyBlogsAction(Model model) {

    }
    /**
     * handle the http get method
     */
    @Override
    public String performGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "login.do";
        }
        return "myblogs.jsp";
    }

    @Override
    public String performPost(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "myblogs.do";
        }

        return "login.jsp";
    }
}
