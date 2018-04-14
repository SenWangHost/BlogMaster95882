package controller;

import databean.Blog;
import databean.Favorite;
import databean.User;
import model.BlogDAO;
import model.FavoriteDAO;
import model.Model;
import org.genericdao.RollbackException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Comparator;

public class MyFavoritesAction extends Action {
    private BlogDAO blogDAO;
    private FavoriteDAO favoriteDAO;
    /**
     * the name of the action
     * @return
     */
    @Override
    public String getName() {
        return "myfavorites.do";
    }
    /**
     * the constructor for this action
     */
    public MyFavoritesAction(Model model) {
        blogDAO = model.getBlogDAO();
        favoriteDAO = model.getFavoriteDAO();
    }

    /**
     *
     * @param request
     *            the request
     * @return
     */
    @Override
    public String performGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "login.do";
        }

        try {
            User user = (User) session.getAttribute("user");
            Favorite[] favorites = favoriteDAO.getAllFavorites(user.getEmail());
            Blog[] blogs = new Blog[favorites.length];
            for (int i = 0; i < favorites.length; i++) {
                blogs[i] = blogDAO.read(favorites[i].getBlogid());
            }
            Arrays.sort(blogs, new BlogComparator());
            request.setAttribute("blogs", blogs);
            return "myfavorites.jsp";
        } catch (RollbackException e) {
            e.printStackTrace();
            return "errors.jsp";
        }
    }

    /**
     *
     * @param request
     *            the request
     * @return
     */
    @Override
    public String performPost(HttpServletRequest request) {
        return performGet(request);
    }

    /**
     * the blog comparator
     */
    public class BlogComparator implements Comparator<Blog> {
        /**
         *
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Blog o1, Blog o2) {
            return o1.getDate().compareTo(o2.getDate()) * -1;
        }
    }
}
