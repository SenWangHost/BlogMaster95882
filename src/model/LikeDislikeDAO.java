package model;

import databean.LikeDislike;
import org.genericdao.*;

public class LikeDislikeDAO extends GenericDAO<LikeDislike> {
    /**
     * the constructor for likedislike dao
     * @param tableName
     * @param connectionPool
     * @throws DAOException
     */
    public LikeDislikeDAO(String tableName, ConnectionPool connectionPool) throws DAOException {
        super(LikeDislike.class, tableName, connectionPool);
    }

    /**
     *
     * @param blogid
     * @return
     * @throws RollbackException
     */
    public LikeDislike getLikeDislike(int blogid, String email) throws RollbackException {
        LikeDislike[] results = match(MatchArg.and(MatchArg.equals("blogid", blogid), MatchArg.equals("email", email)));
        if (results == null || results.length == 0) {
            return null;
        } else {
            return results[0];
        }
    }

}
