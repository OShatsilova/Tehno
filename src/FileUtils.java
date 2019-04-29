import javax.print.DocFlavor;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;

public class FileUtils {

    public static File file = new File("myFile.bin");

    public static void saveToFile(String s) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(s);
        writer.flush();
        writer.close();
        System.out.println("File saved.");
    }

    public static void loadFromFile(IContainer arrayContainer) throws FileNotFoundException {
        Scanner scaner = new Scanner(file);
        String str = "";
        DeviceFactory factory = new DeviceFactory();
        while (scaner.hasNext()) {
            str = scaner.nextLine();
            String s = parsLine(str);
            AbstractDevice abstractDevice = factory.createDevice(s);
            IContainer<AbstractDevice> deviceIContainer = arrayContainer;
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

    public  static void saveAllToFile(IContainer arrayContainer) throws IOException {
        StringBuilder str = new StringBuilder();
        int count = arrayContainer.size();
        if (count == 0) System.out.println("Container is empty, nothing to save.");
        else {
            Object[] array = arrayContainer.toArray();
            for (int i = 0; i < count; i++)
                str.append(array[i]).append("\n");
        }
        FileUtils.saveToFile(str.toString());
    }
}
