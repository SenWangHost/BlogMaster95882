package model;

import databean.Blog;
import org.genericdao.*;

import java.util.Arrays;
import java.util.Comparator;

public class BlogDAO extends GenericDAO<Blog> {
    /**
     * The constructor for the blog dao
     * @param tableName
     * @param connectionPool
     * @throws DAOException
     */
    public BlogDAO(String tableName, ConnectionPool connectionPool) throws DAOException {
        super(Blog.class, tableName, connectionPool);
    }
    /**
     * get all blogs from one author
     * the blogs is sorted in order of time
     */
    public Blog[] getAllBlogs(String email) throws RollbackException {
        // System.out.println("inside getAllBlogs method!");
        Blog[] results = match(MatchArg.equals("email", email));
        Arrays.sort(results, new BlogComparator());
        return results;
    }

    /**
     * get all blogs from all users
     */
    public Blog[] getAllBlogs() throws RollbackException {
        Blog[] results = match();
        if (results != null || results.length > 0) {
            Arrays.sort(results, new BlogComparator());
        }
        return results;
    }
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
