package model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
/**
 * Model class.
 * @author Team 8
 *
 */
public class Model {


    private boolean requireSSL;

    /**
     * Constructor.
     * @param config
     * @throws ServletException
     */
    public Model(ServletConfig config) throws ServletException {

        requireSSL = new Boolean(config.getInitParameter("requireSSL"));
        String jdbcDriver = config.getInitParameter("jdbcDriverName");
        String jdbcURL = config.getInitParameter("jdbcURL");

//        try {
//            ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);
//			/* DAOs */
//
//        } catch (DAOException e) {
//            throw new ServletException(e);
//        }
    }

    public boolean getRequireSSL() {
        return requireSSL;
    }

}
