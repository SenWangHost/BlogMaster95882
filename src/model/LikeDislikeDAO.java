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
     * the function to get one like and dislike
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

    /**
     * The function to get the number of like and dislike
     * @param blogid
     * @return  the first is the number of like, the second is the number of dislike
     * @throws RollbackException
     */
    public int[] getLikeDislikeNumbers(int blogid) throws RollbackException {
        LikeDislike[] list = match(MatchArg.equals("blogid", blogid));
        int[] result = new int[2];
        if (list == null || list.length == 0) {
            return result;
        }
        int like = 0;
        int dislike = 0;
        for (LikeDislike ele : list) {
            if (ele.getStatus()) {
                like++;
            } else {
                dislike++;
            }
        }
        result[0] = like;
        result[1] = dislike;
        return result;
    }

}
