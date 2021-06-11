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

    public void validate(String checkLine) {
        validators = Arrays.asList(emailValidator, phoneValidator, numberValidator, uuidValidator);

        for (Validator validator: validators) {
            if (validator.isValid(checkLine)) {
                System.out.println(validator);
            }
        }
    }
}