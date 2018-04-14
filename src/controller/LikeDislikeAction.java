package controller;

import databean.LikeDislike;
import databean.User;
import model.LikeDislikeDAO;
import model.Model;
import org.genericdao.RollbackException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LikeDislikeAction extends Action {
    private LikeDislikeDAO likeDislikeDAO;
    /**
     * the name of the action
     * @return
     */
    @Override
    public String getName() {
        return "likedislike.do";
    }
    /**
     * the constructor for the action
     */
    public LikeDislikeAction(Model model) {
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
        if (session.getAttribute("user") == null) {
            return "login.do";
        }
        User user = (User) session.getAttribute("user");
        // not a safe way to get parameter
        String bid = request.getParameter("blogid");
        String sta = request.getParameter("status");
        try {
            int blogid = Integer.parseInt(bid);
            boolean status = Integer.parseInt(sta) == 1 ? true : false;
            LikeDislike likeDislike = likeDislikeDAO.getLikeDislike(blogid, user.getEmail());
            if (likeDislike == null) {
                likeDislike = new LikeDislike();
                likeDislike.setBlogid(blogid);
                likeDislike.setEmail(user.getEmail());
                likeDislike.setStatus(status);
                likeDislikeDAO.create(likeDislike);
            } else {
                if (likeDislike.getStatus() != status) {
                    likeDislike.setStatus(status);
                    likeDislikeDAO.update(likeDislike);
                }
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
