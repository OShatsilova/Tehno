import javax.print.DocFlavor;
import java.io.*;
import java.util.Scanner;

public class FileUtils {

    public static File file = new File("myFile.bin");

    public static void saveToFile(String s) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(s);
        writer.close();
        System.out.print("File saved.");
    }

    public static void loadFromFile() throws FileNotFoundException {

        Scanner scaner = new Scanner(file);
        String str = "";
        while (scaner.hasNext()) {
            str = scaner.nextLine();
            String s = parsLine(str);
            AbstractDevice abstractDevice = DeviceFactory.createDevice(s);
            IContainer<AbstractDevice> deviceIContainer = Menu.getDeviceIContainer();
            deviceIContainer.add(abstractDevice);
        }
        System.out.println("File loaded.");
    }

    private static String parsLine(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        str = str.substring(1, str.length() - 1);
        int ind = str.indexOf(" ");
        String s1 = str.substring(0, ind);
        if (s1.equals(Firms.ASUS.toString())) stringBuilder.append(1);
        else stringBuilder.append(2);
        str = str.substring(ind + 1);
        String s2;
        if (str.contains(" ")) {
            ind = str.indexOf(" ");
            s2 = str.substring(0, ind);
        } else
            s2 = str;
        if (s2.equals(DeviceType.NOTEBOOK.toString())) {
            stringBuilder.append(1);
            stringBuilder.append(str.substring(ind + 1));
        } else stringBuilder.append(2);

        return stringBuilder.toString();
    }
}
