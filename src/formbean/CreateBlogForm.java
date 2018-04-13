package formbean;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CreateBlogForm {
    private String action;
    private String content;
    /**
     * the constructor
     */
    public CreateBlogForm(HttpServletRequest request) {
        action = request.getParameter("button");
        content = request.getParameter("content");
    }
    public String getAction() {
        return action;
    }
    public String getContent() {
        return content;
    }
    /**
     * the validation errors
     */
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();
        if (action == null || !action.equals("post")) {
            errors.add("Post action is not sent!");
            return errors;
        }

        if (content == null || content.trim().length() == 0) {
            errors.add("Please fill in valid content!");
            return errors;
        }
        return errors;
    }
}
