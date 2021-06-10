package rent.validator;

public class UuidValidator extends Validator{
    private static final String UUID_PATTERN = "\\w{4}-\\w{4}-\\w{4}-\\w{4}";

    @Override
    public boolean isValid(String checkLine) {
        return createPatternMatcher(UUID_PATTERN, checkLine);
    }
}