package controller;

import databean.Tag;
import databean.User;
import formbean.AddTagForm;
import model.Model;
import model.TagDAO;
import org.genericdao.RollbackException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AddTagAction extends Action {
    private TagDAO tagDAO;
    /**
     * the name of the action
     * @return
     */
    @Override
    public String getName() {
        return "addtag.do";
    }
    /**
     * the constructor of add tag action
     */
    public AddTagAction(Model model) {
        tagDAO = model.getTagDAO();
    }

    /**
     * handle the get request
     * @param request
     *            the request
     * @return
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
        User user = (User) session.getAttribute("user");
        List<String> errors = new ArrayList<>();
        request.setAttribute("errors", errors);
        AddTagForm form = new AddTagForm(request);
        errors.addAll(form.getValidationErrors());
        if (errors.size() > 0) {
//            for (String error : errors) {
//                System.out.println(error);
//            }
            if (form.getPage().equals("homepage")) {
                return "homepage.do";
            } else {
                return "myblogs.do";
            }
        }
        Tag newTag = new Tag();
        newTag.setTagname(form.getTagname());
        newTag.setBlogid(form.getBlogid());
        newTag.setEmail(user.getEmail());
//        System.out.println(newTag.getBlogid());
//        System.out.println(newTag.getTagname());
//        System.out.println(newTag.getEmail());
        try {
            tagDAO.create(newTag);
            if (form.getPage().equals("homepage")) {
                return "homepage.do";
            } else {
                return "myblogs.do";
            }
        } catch (RollbackException e) {
            e.printStackTrace();
            return "errors.jsp";
        }
    }
}
