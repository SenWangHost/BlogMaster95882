package formbean;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class RegisterForm {
    private String email;
    private String password1;
    private String password2;
    private String firstname;
    private String lastname;
    private String action;

    public RegisterForm(HttpServletRequest request) {
        email = request.getParameter("email");
        password1 = request.getParameter("password1");
        password2 = request.getParameter("password2");
        firstname = request.getParameter("firstname");
        lastname = request.getParameter("lastname");
        action = request.getParameter("button");
    }
    public String getEmail() {
        return email;
    }
    public String getPassword1() {
        return password1;
    }

    public String getPassword2() {
        return password2;
    }

    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();
        if (action == null || !action.equals("register")) {
            errors.add("Button action is not sent!");
            return errors;
        }
        if (email == null || email.trim().length() == 0) {
            errors.add("Please fill in your email address!");
            return errors;
        }
        if (password1 == null || password1.trim().length() == 0) {
            errors.add("Your password is missing!");
            return errors;
        }
        if (password2 == null || password2.trim().length() == 0) {
            errors.add("Please repeat your password!");
            return errors;
        }
        if (!password1.equals(password2)) {
            errors.add("Your passwords doesn't match!");
            return errors;
        }
        if (firstname == null || firstname.trim().length() == 0) {
            errors.add("Please fill in your firstname!");
            return errors;
        }
        if (lastname == null || lastname.trim().length() == 0) {
            errors.add("Please fill in your lastname!");
            return errors;
        }
        return errors;
    }

}
