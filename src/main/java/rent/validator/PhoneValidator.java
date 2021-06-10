package rent.validator;

public class PhoneValidator extends Validator{
    private static final String PHONE_PATTERN = "[+]+\\d{12}|[+]+\\d{3}+[(\\d{2})]+\\d{7}|[+]+\\d{3}+[(\\d{2})]+\\d{3}+[-]+\\d{2}+[-]+\\d{2}";

    @Override
    public boolean isValid(String checkLine) {
        return createPatternMatcher(PHONE_PATTERN, checkLine);
    }
}