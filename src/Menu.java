public class Menu {

    static IContainer<AbstractDevice> deviceIContainer = new ArrayContainer<>();

    static private String menuItems = (new StringBuilder()
            .append("\n1 - add element\n")
            .append("2 - update element\n")
            .append("3 - delete element\n")
            .append("4 - print all\n")
            // .append("5 - seve to file\n")
            // .append("6 - load from file\n")
            .append("0 - exit\n"))
            .toString();

    static void printMainMenu() {
        System.out.println(menuItems);
    }

    static private String firmItems = (new StringBuilder()
            .append("1 - Asus\n")
            .append("2 - Dell\n"))
            .toString();

    static void printFirmsItems() {
        System.out.println(firmItems);
    }

    static private String deviceItems = (new StringBuilder()
            .append("1 - Notebook\n")
            .append("2 - Tablet\n"))
            .toString();

    static void printDevicesItems() {
        System.out.println(deviceItems);
    }

    static void run() {
        printMainMenu();
        int[] massOfItems = {1, 2, 3, 4, 0};
        int item = InputUtils.inputItem(massOfItems);
        switch (item) {
            case (1):
                deviceIContainer.add(DeviceFactory.createDevice());
                break;
            case (2):
                System.out.println("Choose element for update:");
                deviceIContainer.printAllWithNum();
                int ind = InputUtils.inputItemFromContainer() - 1;
                deviceIContainer.update(ind, DeviceFactory.createDevice());
                break;
            case (3):
                System.out.println("Choose element for delete:");
                deviceIContainer.printAllWithNum();
                int index = InputUtils.inputItemFromContainer() - 1;
                deviceIContainer.delete(index);
                break;
            case (4):
                deviceIContainer.printAll();
                break;
            case (0):
                Y_Main.stop();
                break;
        }
    }


}
