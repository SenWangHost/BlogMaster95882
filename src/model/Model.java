package model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import databean.LikeDislike;
import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
/**
 * Model class.
 * @author Team 8
 *
 */
public class Model {


    private boolean requireSSL;
    private UserDAO userDAO;
    private BlogDAO blogDAO;
    private FavoriteDAO favoriteDAO;
    private LikeDislikeDAO likeDislikeDAO;

    /**
     * Constructor.
     * @param config
     * @throws ServletException
     */
    public Model(ServletConfig config) throws ServletException {

        requireSSL = new Boolean(config.getInitParameter("requireSSL"));
        String jdbcDriver = config.getInitParameter("jdbcDriverName");
        String jdbcURL = config.getInitParameter("jdbcURL");

        try {
            ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);
			/* DAOs */
			userDAO = new UserDAO("users", pool);
			blogDAO = new BlogDAO("blogs", pool);
			favoriteDAO = new FavoriteDAO("favorites", pool);
			likeDislikeDAO = new LikeDislikeDAO("likedislikes", pool);

        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }

    public boolean getRequireSSL() {
        return requireSSL;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
    public BlogDAO getBlogDAO() { return blogDAO; }
    public FavoriteDAO getFavoriteDAO() { return favoriteDAO;}
    public LikeDislikeDAO getLikeDislikeDAO() { return likeDislikeDAO; }

}
