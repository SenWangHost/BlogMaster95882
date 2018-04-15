package formbean;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class SearchForm {
    private String query;
    private String action;

    public SearchForm(HttpServletRequest request) {
        query = request.getParameter("query");
        action = request.getParameter("button");
    }

    public String getQuery() {
        return query;
    }

    public String getAction() {
        return action;
    }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();
        if (action == null || !action.equals("search")) {
            errors.add("Search action is not sent!");
            return errors;
        }
        if (query == null || query.trim().length() == 0) {
            errors.add("Please fill in the search key words");
            return errors;
        }
        return errors;
    }
}
