package controller;

import databean.Blog;
import databean.Favorite;
import databean.User;
import model.FavoriteDAO;
import model.Model;
import org.genericdao.RollbackException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FavoriteAction extends Action {
    private FavoriteDAO favoriteDAO;
    /**
     * the name of the action.
     * @return
     */
    @Override
    public String getName() {
        return "favorite.do";
    }
    /**
     * the constructor for the action
     */
    public FavoriteAction(Model model) {
        favoriteDAO = model.getFavoriteDAO();
    }
    /**
     *
     */
    @Override
    public String performGet(HttpServletRequest request) {
        return performPost(request);
    }

    @Override
    public String performPost(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "login.do";
        }
        User user = (User) session.getAttribute("user");
        // not a safe way to get parameter
        String bid = request.getParameter("blogid");
        int blogid = 0;
        try {
            blogid = Integer.parseInt(bid);
            Favorite favorite = favoriteDAO.checkFavorite(blogid, user.getEmail());
            if (favorite == null) {
                Favorite newFavorite = new Favorite();
                newFavorite.setBlogid(blogid);
                newFavorite.setEmail(user.getEmail());
                favoriteDAO.create(newFavorite);
            } else {
                favoriteDAO.delete(favorite.getId());
            }
            return "myblogs.do";
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "errors.jsp";
        } catch (RollbackException e) {
            e.printStackTrace();
            return "errors.jsp";
        }
    }
}
