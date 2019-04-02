import java.io.*;
import java.lang.reflect.Array;

public class FileUtils{

    public static void saveToFile(String s) throws IOException{
        File file = new File("myFile.bin");
        FileWriter writer = new FileWriter(file);
        writer.write(s);
        writer.close();

    }
}
