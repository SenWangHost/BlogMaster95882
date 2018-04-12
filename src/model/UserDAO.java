package model;

import databean.User;
import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.RollbackException;

public class UserDAO extends GenericDAO<User> {
    /**
     * The constructor for user dao.
     * @param tableName
     * @param connectionPool
     * @throws DAOException
     */
    public UserDAO(String tableName, ConnectionPool connectionPool) throws DAOException {
        super(User.class, tableName, connectionPool);
    }


}
