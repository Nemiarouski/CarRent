package rent.menu;

import java.util.Scanner;

public class ConsoleReader {

    public static String read(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        String data = scanner.nextLine();
        return data;
    }

    public static String read() {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        return data;
    }
}