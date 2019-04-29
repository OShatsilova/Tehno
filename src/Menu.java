import java.io.IOException;

public class Menu {

    IContainer<AbstractDevice> deviceIContainer;

    public Menu(IContainer<AbstractDevice> deviceIContainer) {
        this.deviceIContainer = deviceIContainer;
    }


/* public IContainer<AbstractDevice> getDeviceIContainer() {

        return deviceIContainer;
    }*/

    private static String menuItems = (new StringBuilder()
            .append("\n1 - add element\n")
            .append("2 - update element\n")
            .append("3 - delete element\n")
            .append("4 - print all\n")
            .append("5 - seve to file\n")
            .append("6 - load from file\n")
            .append("0 - exit\n"))
            .toString();

    static void printMainMenu() {
        System.out.println(menuItems);
    }

    private static String firmItems = (new StringBuilder()
            .append("1 - Asus\n")
            .append("2 - Dell\n"))
            .toString();

    static void printFirmsItems() {
        System.out.println(firmItems);
    }


    void run() throws IOException, ClassNotFoundException {
        while (true) {
            printMainMenu();
            int[] massOfItems = {1, 2, 3, 4, 5, 6, 0};
            // проверяю ввод данных пользователем
            int item = InputUtils.inputItem(massOfItems);
            switch (item) {
                case (1):
                    deviceIContainer.add(DeviceFactory.createDevice());
                    break;
                case (2):
                    if (deviceIContainer.size() != 0) {
                        System.out.println("Choose element for update:");
                        deviceIContainer.printAllWithNum();
                        int ind = InputUtils.inputItemFromContainer(deviceIContainer.size()) - 1;
                        deviceIContainer.update(ind, DeviceFactory.createDevice());
                    } else System.out.println("Nothing to update.");

                    break;
                case (3):
                    if (deviceIContainer.size() != 0) {
                        System.out.println("Choose element for delete:");
                        deviceIContainer.printAllWithNum();
                        int index = InputUtils.inputItemFromContainer(deviceIContainer.size()) - 1;
                        deviceIContainer.delete(index);
                    } else System.out.println("Nothing to delete.");
                    break;
                case (4):
                    deviceIContainer.printAll();
                    break;
                case (5):
                    FileUtils.saveAllToFile(deviceIContainer);
                    break;
                case (6):
                    FileUtils.loadFromFile(deviceIContainer);
                    break;
                case (0):
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }

    void test() throws IOException, ClassNotFoundException {
        /*System.out.println("Test start..." + System.currentTimeMillis());
        for (int i = 1; i < 1000001; i++)
            deviceIContainer.add(DeviceFactory.createDevice("12"));
        deviceIContainer.saveAllToFile();
        System.out.println("Test end....." + System.currentTimeMillis());*/
    }


}
