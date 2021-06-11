package rent.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Menu {
    private List<Validator> validators = new ArrayList<>();
    private TextChecker textChecker = new TextChecker();

    public void menuOutput() {
        List<String> mainMenu = List.of("Validate", "Count", "Replace", "Exit");
        System.out.println("Choose the option:");
        for (int i = 0; i < mainMenu.size(); i++) {
            System.out.println(i + 1 + ") " + mainMenu.get(i));
        }
    }

    private void validatorsToList() {
        validators = List.of(new PhoneValidator(), new EmailValidator(), new NumberValidator(), new UuidValidator());
    }

    public void validate(String checkLine) {
        validatorsToList();
        Validator condition = isValid(checkLine);

        if (condition != null) {
            System.out.println(condition);
        } else {
            System.out.println("Unknown format");
        }
    }

    private Validator isValid(String checkLine) {
        for (Validator validator: validators) {
            if (validator.isValid(checkLine)) {
                return validator;
            }
        }
        return null;
    }

    public void countString() {
        Matcher matcher = createMatcher();
        System.out.println("Число вхождений строки в текст = " + countLines(matcher));
    }

    public void replaceString() {
        Matcher matcher = createMatcher();
        System.out.println("Replace word: ");
        System.out.println(matcher.replaceAll(Reader.read()));
    }

    private Matcher createMatcher() {
        System.out.println("Input your text:");
        String text = Reader.read();

        System.out.println("Input your line:");
        String line = Reader.read();

        return textChecker.creatingMatcher(line, text);
    }

    private int countLines(Matcher matcher) {
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }
}