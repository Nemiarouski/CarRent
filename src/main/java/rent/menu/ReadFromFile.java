package rent.menu;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFromFile {

    public static String readFromFile(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(fileReader);
        String carString = "";
        while (scanner.hasNextLine()) {
            carString = carString + scanner.nextLine();
        }
        fileReader.close();
        return carString;
    }
}