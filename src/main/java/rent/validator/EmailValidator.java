package rent.validator;

public class EmailValidator extends Validator{
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    protected String getPattern() {
        return EMAIL_PATTERN;
    }

    @Override
    public String toString() {
        return "Email";
    }
}