import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils{

    public static void saveToFile(String s) throws IOException{
        File file = new File("myFile.bin");
        FileWriter writer = new FileWriter(file);
        writer.write(s);
        writer.close();

    }
}
