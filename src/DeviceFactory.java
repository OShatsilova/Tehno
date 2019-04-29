public class DeviceFactory {

    static private int deviceType;
    static private int deviceFirm;
    static private double deviceModelNum = 0.0;

    private static String deviceItems = (new StringBuilder()
            .append("1 - Notebook\n")
            .append("2 - Tablet\n"))
            .toString();

    static void printDevicesItems() {
        System.out.println(deviceItems);
    }

    public static AbstractDevice createDevice() {
        System.out.println("Choose device, available items:");
        printDevicesItems();
        int[] massOfItems = {1, 2};
        deviceType = InputUtils.inputItem(massOfItems);
        System.out.println("Choose device firm, available items:");
        Menu.printFirmsItems();
        deviceFirm = InputUtils.inputItem(massOfItems);
        if (deviceType == 1) {
            System.out.println("Input notebook model number");
            deviceModelNum = InputUtils.inputModelNum();
        }
        return makeDevice(deviceType, deviceFirm, deviceModelNum);
    }

    public AbstractDevice createDevice(String str) {
        deviceFirm = Integer.valueOf(str.substring(0, 1));
        deviceType = Integer.valueOf(str.substring(1, 2));
        if (deviceType == 1) {
            deviceModelNum = Double.parseDouble(str.substring(2));
        }
        return makeDevice(deviceType, deviceFirm, deviceModelNum);
    }

    public static AbstractDevice makeDevice(int deviceType, int deviceFirm, double deviceModelNum) {

        AbstractDevice device = new AbstractDevice();

        switch (deviceType) {
            case 1: {
                device = new Notebook(deviceModelNum);
                break;
            }
            case 2: {
                device = new Tablet();
                break;
            }
        }
        switch (deviceFirm) {
            case 1:
                device.setDeviceFirm(Firms.ASUS);
                break;
            case 2: {
                device.setDeviceFirm(Firms.DELL);
                break;
            }
        }
        return device;
    }
}