package model;

import databean.Favorite;
import org.genericdao.*;

public class FavoriteDAO extends GenericDAO<Favorite> {
    /**
     * The constructor
     * @param tableName
     * @param connectionPool
     * @throws DAOException
     */
    public FavoriteDAO(String tableName, ConnectionPool connectionPool) throws DAOException {
        super(Favorite.class, tableName, connectionPool);
    }
    /**
     * check whether the author has favorited a certain blog
     */
    public Favorite checkFavorite(int blogid, String email) throws RollbackException {
        Favorite[] favorites = match(MatchArg.and(MatchArg.equals("blogid", blogid), MatchArg.equals("email", email)));
        if (favorites.length == 0) {
            return null;
        } else {
            return favorites[0];
        }
    }
    /**
     * the functionality to get the number of functionality for one block
     */
    public int getFavoriteNumber(int blogid) throws RollbackException {
        Favorite[] favorites = match(MatchArg.equals("blogid", blogid));
        return favorites.length;
    }
}
