package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;
/**
 * Controller for actions.
 * @author Team 8
 *
 */
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Model model;

    @Override
    public void init() throws ServletException {
        model = new Model(getServletConfig());

		/* Actions here */
		Action.add(new LoginAction(model));

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (model.getRequireSSL() && !request.isSecure()) {
//            // If we're required to use SSL and we're not on a secure connection, redirect
//            String host = request.getServerName();
//            String port = (request.getServerPort() == 80) ? "" : ":8443";
//            response.sendRedirect("https://" + host + port + request.getRequestURI());
//            return;
//        }

        String nextPage = performTheAction(request);
        sendToNextPage(nextPage, request, response);
    }

    private String performTheAction(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        String action = getActionName(servletPath);


        System.out.println("ServletPath: "+servletPath);
        System.out.println("[perform the action]Action: " + action);

        return Action.perform(action, request);
    }

    private void sendToNextPage(String nextPage, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // System.out.println(nextPage);
        if (nextPage == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, request.getServletPath());
            return;
        }

        if (nextPage.endsWith(".do")) {
            response.sendRedirect(nextPage);
            return;
        }

        if (nextPage.endsWith(".jsp")) {
            RequestDispatcher d = request.getRequestDispatcher("WEB-INF/view/" + nextPage);
            d.forward(request, response);
            return;
        }

        throw new ServletException(
                Controller.class.getName() + ".sendToNextPage(\"" + nextPage + "\"): invalid extension.");
    }

    private String getActionName(String path) {
        int slash = path.lastIndexOf('/');
        return path.substring(slash + 1);
    }
}
