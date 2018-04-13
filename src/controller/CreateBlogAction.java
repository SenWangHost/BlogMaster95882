package controller;

import databean.Blog;
import databean.User;
import formbean.CreateBlogForm;
import model.BlogDAO;
import model.Model;
import org.genericdao.RollbackException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateBlogAction extends Action {
    private BlogDAO blogDAO;
    /**
     * the name of the action
     * @return
     */
    @Override
    public String getName() {
        return "createblog.do";
    }
    /**
     * the constructor
     */
    public CreateBlogAction(Model model) {
        blogDAO = model.getBlogDAO();
    }
    /**
     * handle the http get method
     */
    @Override
    public String performGet(HttpServletRequest request) {
        return performPost(request);
    }

    /**
     * handle the post request
     * @param request
     *            the request
     * @return
     */
    @Override
    public String performPost(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "login.do";
        }
        List<String> errors = new ArrayList<>();
        session.setAttribute("errors", errors);
        CreateBlogForm createBlogForm = new CreateBlogForm(request);
        session.setAttribute("form", createBlogForm);
        errors.addAll(createBlogForm.getValidationErrors());
        if (errors.size() > 0) {
            return "myblogs.do";
        }
        // create a new blog
        User user = (User) session.getAttribute("user");
        Blog blog = new Blog();
        blog.setAuthor(user.getFirstname() + " " + user.getLastname());
        blog.setContent(createBlogForm.getContent());
        blog.setDate(new Date());
        blog.setEmail(user.getEmail());
        try {
            blogDAO.create(blog);
            return "myblogs.do";
        } catch (RollbackException e) {
            e.printStackTrace();
            return "errors.jsp";
        }
    }
}
