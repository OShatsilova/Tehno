import java.io.IOException;

public class Y_Main {

    private static int flagToStop = 0;

    public static void main(String args[]) throws IOException, ClassNotFoundException {

        while (flagToStop == 0) Menu.run();
    }

    public static void stop() {
        flagToStop = 1;
        System.out.println("The end!");
    }
}
