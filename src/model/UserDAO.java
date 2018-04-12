package model;

import databean.User;
import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.RollbackException;

public class UserDAO extends GenericDAO<User> {
    /**
     * The constructor for user dao.
     * @param beanClass
     * @param tableName
     * @param connectionPool
     * @throws DAOException
     */
    public UserDAO(String tableName, ConnectionPool connectionPool) throws DAOException {
        super(User.class, tableName, connectionPool);
    }

    /**
     * The method to create a customer
     * @param user
     * @throws RollbackException
     */
    public void createUser(User user) throws RollbackException {
        create(user);
    }

    public User getUser(String email) throws  RollbackException {
        return read(email);
    }


}
