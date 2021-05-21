package rent.menu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public static void writeToFileAppend(File file, Object object) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write("\n");
        fileWriter.write(object.toString());
        fileWriter.flush();
        fileWriter.close();
    }

    public static void writeToFile(File file, Object object) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(object.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}