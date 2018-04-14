package controller;

import databean.Blog;
import databean.Favorite;
import databean.LikeDislike;
import databean.User;
import model.BlogDAO;
import model.FavoriteDAO;
import model.LikeDislikeDAO;
import model.Model;
import org.genericdao.RollbackException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HomepageAction extends Action {
    private BlogDAO blogDAO;
    private FavoriteDAO favoriteDAO;
    private LikeDislikeDAO likeDislikeDAO;
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
        blogDAO = model.getBlogDAO();
        favoriteDAO = model.getFavoriteDAO();
        likeDislikeDAO = model.getLikeDislikeDAO();
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
        User user = (User) session.getAttribute("user");
        try {
            Blog[] myblogs = blogDAO.getAllBlogs();
            boolean[] fStatuses = new boolean[myblogs.length];
            int[] fNumbers = new int[myblogs.length];
            LikeDislike[] ldlist = new LikeDislike[myblogs.length];
            int[] likeNumbers = new int[myblogs.length];
            int[] dislikeNumbers = new int[myblogs.length];
            for (int i = 0; i < myblogs.length; i++) {
                Blog blog = myblogs[i];
                Favorite favorite = null;
                if (user != null) {
                    favorite = favoriteDAO.checkFavorite(blog.getId(), user.getEmail());
                }
                fNumbers[i] = favoriteDAO.getFavoriteNumber(blog.getId());
                if (user != null) {
                    ldlist[i] = likeDislikeDAO.getLikeDislike(blog.getId(), user.getEmail());
                }
                // System.out.println(ldlist[i]);
                int[] temp = likeDislikeDAO.getLikeDislikeNumbers(blog.getId());
                likeNumbers[i] = temp[0];
                dislikeNumbers[i] = temp[1];
                System.out.println(likeNumbers[i] + " " + dislikeNumbers[i]);
                if (favorite == null) {
                    fStatuses[i] = false;
                } else {
                    fStatuses[i] = true;
                }
            }
            request.setAttribute("blogs", myblogs);
            request.setAttribute("fStatuses", fStatuses);
            request.setAttribute("fNumbers", fNumbers);
            request.setAttribute("ldlist", ldlist);
            request.setAttribute("likeNumbers", likeNumbers);
            request.setAttribute("dislikeNumbers", dislikeNumbers);
            return "homepage.jsp";
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
}
