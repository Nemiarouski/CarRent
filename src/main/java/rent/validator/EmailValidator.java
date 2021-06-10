package rent.validator;

public class EmailValidator extends Validator{
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public boolean isValid(String checkLine) {
        return createPatternMatcher(EMAIL_PATTERN, checkLine);
    }
}