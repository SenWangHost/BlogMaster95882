package model;


import databean.Tag;
import org.genericdao.*;

public class TagDAO extends GenericDAO<Tag> {
    /**
     * @param tableName
     * @param connectionPool
     * @throws DAOException
     */
    public TagDAO(String tableName, ConnectionPool connectionPool) throws DAOException {
        super(Tag.class, tableName, connectionPool);
    }

    /**
     * the function to get all tags for one blog
     * @param blogid
     * @return
     * @throws RollbackException
     */
    public Tag[] getAllTags(int blogid) throws RollbackException {
        Tag[] tags = match(MatchArg.equals("blogid", blogid));
        return tags;
    }
}
