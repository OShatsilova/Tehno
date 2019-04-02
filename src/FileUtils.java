import java.io.*;

public class FileUtils{

    public static void saveToFile() throws IOException{
        File file = new File("myFile.bin");
        FileWriter writer = new FileWriter(file);
        writer.write("ggggggg");
        writer.close();

    }
}
