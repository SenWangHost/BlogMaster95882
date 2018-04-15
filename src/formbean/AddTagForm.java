package formbean;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class AddTagForm {
    private String blogid;
    private String tagname;
    private String action;
    private String page;

    public AddTagForm(HttpServletRequest request) {
        blogid = request.getParameter("blogid");
        tagname = request.getParameter("tagname");
        action = request.getParameter("button");
        page = request.getParameter("page");
    }

    public int getBlogid() {
        return Integer.parseInt(blogid);
    }

    public String getTagname() {
        return tagname;
    }

    public String getAction() {return action;}

    public String getPage() { return page; }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();

        if (action == null || !action.equals("add")) {
            errors.add("Add action is not sent!");
            return errors;
        }
        if (tagname == null || tagname.length() == 0) {
            errors.add("Please provide a tagname!");
            return errors;
        }
        if (blogid == null || blogid.length() == 0) {
            errors.add("No blogid is received!");
            return errors;
        }
        if (page == null || (!page.equals("homepage") && !page.equals("myblogs"))) {
            errors.add("Invalid page parameter");
            return errors;
        }
        try {
            int id = Integer.parseInt(blogid);
        } catch (NumberFormatException e) {
            errors.add("Invalid format for blogid!");
            return errors;
        }
        return errors;

    }
}
