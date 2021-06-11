package rent.validator;

public class StartMenu {
    public static void main(String[] args) {
        Menu menu = new Menu();
        while (true) {
            System.out.println("Check your line:");
            String checkLine = Reader.read();
            if (checkLine.equals("false")) {
                break;
            }
            menu.validate(checkLine);
        }
    }
}