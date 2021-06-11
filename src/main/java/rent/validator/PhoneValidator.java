package rent.validator;

public class PhoneValidator extends Validator{
    private static final String PHONE_PATTERN = "[+]+\\d{3}+[(\\d{2})]+\\d{7}|[+]+\\d{3}+[(\\d{2})]+\\d{3}+[-]+\\d{2}+[-]+\\d{2}";

    @Override
    protected String getPattern() {
        return PHONE_PATTERN;
    }

    @Override
    public String toString() {
        return "Phone number";
    }
}