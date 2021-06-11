package rent.validator;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<Validator> validators = new ArrayList<>();

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
}