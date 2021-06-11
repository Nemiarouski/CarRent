package rent.validator;

public class StartMenu {
    public static void main(String[] args) {
        Menu menu = new Menu();
        while (true) {
            System.out.println("Write your line:");
            String checkLine = Reader.read();
            if (!checkLine.equals("false")) {
                if (checkLine.equalsIgnoreCase("count")) {
                    menu.findString();
                } else if (checkLine.equalsIgnoreCase("replace")) {
                    menu.replaceString();
                } else {
                    menu.validate(checkLine);
                }
            } else {
                break;
            }
        }
    }
}