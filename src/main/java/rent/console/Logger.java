package rent.console;

public class Logger {
    public void log(String value) {
        System.out.println(value);
    }

    private static Logger instance;
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}
