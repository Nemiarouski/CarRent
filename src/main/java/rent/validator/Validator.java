package rent.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validator {
    protected boolean createPatternMatcher(String regExLine, String checkLine) {
        Pattern pattern = Pattern.compile(regExLine);
        Matcher matcher = pattern.matcher(checkLine);
        return matcher.matches();
    }

    protected boolean isValid(String checkLine) {
        return createPatternMatcher(getPattern(), checkLine);
    }

    protected abstract String getPattern();
}