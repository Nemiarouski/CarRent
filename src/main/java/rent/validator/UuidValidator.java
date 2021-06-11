package rent.validator;

public class UuidValidator extends Validator{
    private static final String UUID_PATTERN = "\\w{4}-\\w{4}-\\w{4}-\\w{4}";

    @Override
    protected String getPattern() {
        return UUID_PATTERN;
    }

    @Override
    public String toString() {
        return "Uuid";
    }
}