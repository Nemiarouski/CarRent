package rent.menu;

import java.util.Scanner;

public class Console {

    public static String read(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        String data = scanner.nextLine();
        return data;
    }
}