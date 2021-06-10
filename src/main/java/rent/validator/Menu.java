package rent.validator;

public class Menu {
    EmailValidator emailValidator = new EmailValidator();
    PhoneValidator phoneValidator = new PhoneValidator();
    NumberValidator numberValidator = new NumberValidator();
    UuidValidator uuidValidator = new UuidValidator();

    public void validate(String checkLine) {
        if (emailValidator.isValid(checkLine)) {
            System.out.println("Email.");
        }

        if (phoneValidator.isValid(checkLine)) {
            System.out.println("Phone number.");
        }

        if (uuidValidator.isValid(checkLine)) {
            System.out.println("UUID code.");
        }

        if (numberValidator.isValid(checkLine)) {
            System.out.println("Number");
        }
    }
}