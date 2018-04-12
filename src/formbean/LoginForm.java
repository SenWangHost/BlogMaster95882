package formbean;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class LoginForm {
    /**
     *
     */
    private String email;
    /**
     *
     */
    private String password;
    /**
     *
     */
    private String action;
    /**
     * the constructor
     */
    public LoginForm(HttpServletRequest request) {
        email = request.getParameter("email");
        password = request.getParameter("password");
        action = request.getParameter("button");
        if (email != null) {
            email = email.trim();
        }
        if (password != null) {
            password = password.trim();
        }
        if (action != null) {
            action = action.trim();
        }
    }
    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    public String getAction() {
        return action;
    }
    /**
     * the validation method
     *
     */
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (action == null) {
            errors.add("Button Action is not sent!");
            return errors;
        }

        if (!action.equals("login")) {
            errors.add("This is not login action!");
            return errors;
        }

        if (email == null || email.length() == 0) {
            errors.add("Please fill in your email address!");
            return errors;
        }

        if (password == null || password.length() == 0) {
            errors.add("Please fill in your password");
            return errors;
        }
        return errors;

    }



}
