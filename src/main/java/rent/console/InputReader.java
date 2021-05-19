package rent.console;

import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;

    public InputReader() {
        scanner = new Scanner(System.in);
    }

    public String waitForInput() {
        return scanner.nextLine();
    }

    private static InputReader instance;
    public static InputReader getInstance() {
        if (instance == null) {
            instance = new InputReader();
        }
        return instance;
    }
}
