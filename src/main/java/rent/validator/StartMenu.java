package rent.validator;

public class StartMenu {
    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean whileCondition = true;
        menu.menuOutput();

        while (whileCondition) {
            String menuOption = Reader.read();
            switch (menuOption) {
                case "1":
                    System.out.println("Write your line:");
                    String checkLine = Reader.read();
                    menu.validate(checkLine);
                    break;
                case "2":
                    menu.countString();
                    break;
                case "3":
                    menu.replaceString();
                    break;
                case "4":
                    System.out.println("Have a good day!");
                    whileCondition = false;
                default:
                    System.out.println("Wrong menu option.");
                    break;
            }
        }
    }
}