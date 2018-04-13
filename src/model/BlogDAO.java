package model;

import databean.Blog;
import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

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

}
