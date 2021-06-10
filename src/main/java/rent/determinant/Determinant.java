package rent.determinant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Determinant {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String UUID_PATTERN = "\\w{4}-\\w{4}-\\w{4}-\\w{4}";
    private static final String NUMBERS_PATTERN = "^[-+]?[0-9]*[.,]?[0-9]+(?:[eE][-+]?[0-9]+)?$";
    // work with +xxxxxxxxxxxx & +xxx(xx)xxxxxxx & +xxx(xx)xxx-xx-xx
    private static final String PHONE_PATTERN = "[+]+\\d{12}|[+]+\\d{3}+[(\\d{2})]+\\d{7}|[+]+\\d{3}+[(\\d{2})]+\\d{3}+[-]+\\d{2}+[-]+\\d{2}";


    public static void main(String[] args) {
        System.out.println("Welcome to our program! Input your line:");
        //String line = Reader.read();

        String email = "nemiaroiskipetr@gmail.com";
        String uuid = "1234-5678-90AB-CDEF";
        String phoneNumber = "+375(29)2899959";
        String phoneNumber1 = "+375292899959";
        String phoneNumber2 = "+375(29)289-99-59";
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

        System.out.println();
        System.out.println("Determ phone number: " + phoneNumber2);
        determinePhoneNumber(phoneNumber2);

    }

    public static void determineEmail(String lineToDeterm) {
        System.out.println(createPatternMatcher(EMAIL_PATTERN, lineToDeterm));
    }

    public static void determineUuid(String lineToDeterm) {
        if (lineToDeterm.length() == 19) {
            System.out.println(createPatternMatcher(UUID_PATTERN, lineToDeterm));
        }
    }

    public static void determineNumbers(String linetoDeterm) {
        System.out.println(createPatternMatcher(NUMBERS_PATTERN, linetoDeterm));
    }

    public static void determinePhoneNumber(String lineToDeterm) {
        System.out.println(createPatternMatcher(PHONE_PATTERN, lineToDeterm));
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
    3) phone number (формат +xxx(xx)xxx-xx-xx), где x- цифра, минусы опциональны                                    -> DONE
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