package rent.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validator {
    public boolean createPatternMatcher(String regExLine, String checkLine) {
        Pattern pattern = Pattern.compile(regExLine);
        Matcher matcher = pattern.matcher(checkLine);
        return matcher.matches();
    }

    public abstract boolean isValid(String checkLine);
}