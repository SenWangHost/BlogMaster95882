package controller;

import databean.*;
import model.*;
import org.genericdao.RollbackException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class MyBlogsAction extends Action {
    private BlogDAO blogDAO;
    private FavoriteDAO favoriteDAO;
    private LikeDislikeDAO likeDislikeDAO;
    private TagDAO tagDAO;
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
        likeDislikeDAO = model.getLikeDislikeDAO();
        tagDAO = model.getTagDAO();
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
            int[] fNumbers = new int[myblogs.length];
            LikeDislike[] ldlist = new LikeDislike[myblogs.length];
            int[] likeNumbers = new int[myblogs.length];
            int[] dislikeNumbers = new int[myblogs.length];
            List<Tag[]> allTags = new ArrayList<>();
            for (int i = 0; i < myblogs.length; i++) {
                Blog blog = myblogs[i];
                Favorite favorite = favoriteDAO.checkFavorite(blog.getId(), user.getEmail());
                fNumbers[i] = favoriteDAO.getFavoriteNumber(blog.getId());
                ldlist[i] = likeDislikeDAO.getLikeDislike(blog.getId(), user.getEmail());
                // System.out.println(ldlist[i]);
                int[] temp = likeDislikeDAO.getLikeDislikeNumbers(blog.getId());
                likeNumbers[i] = temp[0];
                dislikeNumbers[i] = temp[1];
                // System.out.println(likeNumbers[i] + " " + dislikeNumbers[i]);
                Tag[] tags = tagDAO.getAllTags(blog.getId());
                allTags.add(tags);
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
            request.setAttribute("allTags", allTags);
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
