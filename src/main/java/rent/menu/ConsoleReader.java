package rent.menu;

import java.util.Scanner;

public class ConsoleReader {

    public static String consoleReader(String textString) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(textString);
        String dataString = scanner.nextLine();
        return dataString;
    }

    public static String consoleReader() {
        Scanner scanner = new Scanner(System.in);
        String dataString = scanner.nextLine();
        return dataString;
    }
}