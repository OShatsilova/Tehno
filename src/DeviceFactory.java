public class DeviceFactory {

    private static int deviceType;
    private static int deviceFirm;
    private static double deviceModelNum = 0.0;

    public static AbstractDevice createDevice() {
        System.out.println("Choose device, available items:");
        Menu.printDevicesItems();
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

    public static AbstractDevice createDevice(String str) {
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