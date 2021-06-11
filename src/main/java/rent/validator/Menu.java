package rent.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    Validator emailValidator = new EmailValidator();
    Validator phoneValidator = new PhoneValidator();
    Validator numberValidator = new NumberValidator();
    Validator uuidValidator = new UuidValidator();
    List<Validator> validators = new ArrayList<>();

    private void validatorsToList() {
        validators = Arrays.asList(phoneValidator, emailValidator, numberValidator, uuidValidator);
    }

    public void validate(String checkLine) {
        validatorsToList();
        if (isValid(checkLine) != null) {
            System.out.println(isValid(checkLine));
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
}