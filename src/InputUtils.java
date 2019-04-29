import java.util.Scanner;

public class InputUtils {

    public static Scanner scan = new Scanner(System.in);

    public static int inputItem(int[] items) {
        int item = -1;
        while (item == -1) {
            try {
                item = scan.nextInt();
                boolean flag = false;
                for (int i : items) {
                    if (i == item) flag = true;
                }
                if (!flag) {
                    System.out.print("Значение должно быть выбрано из представленных вариантов: " + print(items) + ". Повторите попытку. ");
                    item = -1;
                }
            } catch (Exception e) {
                System.out.print("Значение должно быть выбрано из представленных вариантов: " + print(items) + ". Повторите попытку: ");
                scan.next();
            }
        }
        return item;
    }

    public static double inputModelNum() {
        double num = 0.0;
        boolean flag = false;
        while (flag == false) {
            try {
                num = scan.nextDouble();
                flag = true;
                break;
            } catch (Exception e) {
                System.out.println("Значение должно быть double через запятую. Пример: 2,0");
                scan.next();
            }
        }
        return num;
    }

    public static String print(int[] items) {
        StringBuilder str = new StringBuilder();
        str.append(items[0]);

        for (int i = 1; i < items.length; i++) {
            str.append(",").append(items[i]);
        }
        return str.toString();
    }

    public static int inputItemFromContainer(int containerSize) {
        int[] items = new int[containerSize];
        for (int i = 0; i < items.length; i++) {
            items[i] = i + 1;
        }
        int item = inputItem(items);
        return item;
    }
}
