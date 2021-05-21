package rent.menu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public static void writeAppend(File file, Object object) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(object.toString());
        fileWriter.write("\n");
        fileWriter.flush();
        fileWriter.close();
    }

    public static void write(File file, Object object) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(object.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}