package rent.menu;

import java.io.File;
// Изучить пакет import java.nio.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFromFile {

    public static String read(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(fileReader);
        String carString = "";

        while (scanner.hasNextLine()) {
            carString = carString + scanner.nextLine()  + "\n";
        }

        fileReader.close();
        return carString;
    }
}