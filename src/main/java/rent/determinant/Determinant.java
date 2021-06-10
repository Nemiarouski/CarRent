package rent.determinant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Determinant {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    //private static final String UUID_PATTERN = "^[0-9A-Za-z]{16}$";
    private static final String UUID_PATTERN = "[0-9A-Za-z]-[0-9A-Za-z]-[0-9A-Za-z]-[0-9A-Za-z]" +
            "-[0-9A-Za-z]-[0-9A-Za-z]-[0-9A-Za-z]-[0-9A-Za-z]" +
            "-[0-9A-Za-z]-[0-9A-Za-z]-[0-9A-Za-z]-[0-9A-Za-z]" +
            "-[0-9A-Za-z]-[0-9A-Za-z]-[0-9A-Za-z]-[0-9A-Za-z]";

    private static final String NUMBERS_PATTERN = "^[-+]?[0-9]*[.,]?[0-9]+(?:[eE][-+]?[0-9]+)?$";

    public static void main(String[] args) {
        System.out.println("Welcome to our program! Input your line:");
        //String line = Reader.read();

        String email = "nemiaroiskipetr@gmail.com";
        String uuid = "1-2-3-4-5-6-7-8-9-0-A-B-C-D-E-F";
        String phoneNumber = "+375(29)2899959";
        String phoneNumber1 = "+375(29)289-99-59";
        //url (http(s)://some_url_value.some_suffix)
        String url = "http://stackoverflow.com";
        //число (как целочисленное, так и дробное) (набор цифр) (как доп. задание - учитывать тысячный разделитель)
        int num = 1;
        int num1 = -5;
        double dnum = -0.05;
        double dnum1 = 3.5;

        // Email validation
        System.out.println("\nDeterm email: " + email);
        determineEmail(email);

        // UUID validation
        System.out.println();
        System.out.println("Determ UUID: " + uuid);
        determineUuid(uuid);

        // Numbers
        System.out.println();
        System.out.println("Determ numbers");
        determineNumbers(String.valueOf(num));
        determineNumbers(String.valueOf(num1));
        determineNumbers(String.valueOf(dnum));
        determineNumbers(String.valueOf(dnum1));

        // Phone number
        System.out.println();
        System.out.println("Determ phone number: " + phoneNumber);
        determinePhoneNumber(phoneNumber);

        System.out.println();
        System.out.println("Determ phone number: " + phoneNumber1);
        determinePhoneNumber(phoneNumber1);

    }

    public static void determineEmail(String lineToDeterm) {
        System.out.println(createPatternMatcher(EMAIL_PATTERN, lineToDeterm));
    }

    public static void determineUuid(String lineToDeterm) {
        if (lineToDeterm.length() == 31) {
            System.out.println(createPatternMatcher(UUID_PATTERN, lineToDeterm));
        }
    }

    public static void determineNumbers(String linetoDeterm) {
        System.out.println(createPatternMatcher(NUMBERS_PATTERN, linetoDeterm));
    }

    public static void determinePhoneNumber(String lineToDeterm) {
/*        Pattern pattern = patternCreator("\\+\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");
        //формат +xxx(xx)xxx-xx-xx
        Pattern pattern1 = patternCreator("^[+]?\\d{3}\\(\\d{2})?\\d{3}?\\d{2}?\\d{2}$");
        Matcher matcher = matcherCreator(pattern1, lineToDeterm);
        System.out.println(matcher.matches());*/
    }

    public static boolean createPatternMatcher(String regExLine, String lineToDeterm) {
        Pattern pattern = Pattern.compile(regExLine);
        Matcher matcher = pattern.matcher(lineToDeterm);
        return matcher.matches();
    }
}
/* Консольное приложение, которое валидирует и определяет тип введенных данных, поддерживаемые форматы:
    1) email                                                                                                        -> DONE
    2) UUID (в нашей ситуации будем считать, что это 16 букв/цифр), каждые 4 разделены знаком "-"                   -> DONE
    3) phone number (формат +xxx(xx)xxx-xx-xx), где x- цифра, минусы опциональны
    4) url (http(s)://some_url_value.some_suffix)
    5) число (как целочисленное, так и дробное) (набор цифр) (как доп. задание - учитывать тысячный разделитель)    -> DONE
    6) иначе вывод сообщения "неизвестный формат"
    ?) работа со спец символами, н-р слэш ("/"), экранирование спец символов

Дополнительные возможности:
    - дать возможность ввести текст, после этого ввести какую то строку
                    для поиска и подсчитать количество появлений этой строки в тексте

    - дать возможность ввести текст, после этого ввести какую то строку
                    для поиска и вывести обновленный вариант текста

Tips: Применять ООП подходы. */