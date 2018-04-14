package controller;

import databean.Blog;
import databean.Favorite;
import databean.User;
import formbean.LoginForm;
import model.BlogDAO;
import model.FavoriteDAO;
import model.Model;
import org.genericdao.RollbackException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyBlogsAction extends Action {
    private BlogDAO blogDAO;
    private FavoriteDAO favoriteDAO;
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
        blogDAO = model.getBlogDAO();
        favoriteDAO = model.getFavoriteDAO();
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
        User user = (User) session.getAttribute("user");
        try {
            Blog[] myblogs = blogDAO.getAllBlogs(user.getEmail());
            boolean[] fStatuses = new boolean[myblogs.length];
            for (int i = 0; i < myblogs.length; i++) {
                Blog blog = myblogs[i];
                Favorite favorite = favoriteDAO.checkFavorite(blog.getId(), user.getEmail());
                if (favorite == null) {
                    fStatuses[i] = false;
                } else {
                    fStatuses[i] = true;
                }
            }
            session.setAttribute("blogs", myblogs);
            session.setAttribute("fStatuses", fStatuses);
            return "myblogs.jsp";
        } catch (RollbackException e) {
            e.printStackTrace();
            return "errors.jsp";
        }
    }

    @Override
    public String performPost(HttpServletRequest request) {
        return performGet(request);
    }
}
