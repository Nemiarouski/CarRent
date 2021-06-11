package rent.validator;

public class NumberValidator extends Validator{
    private static final String NUMBER_PATTERN = "^[-+]?[0-9]*[.,]?[0-9]+(?:[eE][-+]?[0-9]+)?$";

    @Override
    protected boolean isValid(String checkLine) {
        return createPatternMatcher(NUMBER_PATTERN, checkLine);
    }

    @Override
    public String toString() {
        return "Number";
    }
}