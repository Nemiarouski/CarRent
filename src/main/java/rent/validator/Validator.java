package rent.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validator {
    protected Matcher creatingMatcher(String regExLine, String checkLine) {
        Pattern pattern = Pattern.compile(regExLine);
        Matcher matcher = pattern.matcher(checkLine);
        return matcher;
    }

    protected boolean isValid(String checkLine) {
        return creatingMatcher(getPattern(), checkLine).matches();
    }

    protected abstract String getPattern();
}