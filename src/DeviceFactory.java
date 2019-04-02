public class DeviceFactory {

    public static AbstractDevice createDevice() {
        System.out.println("Choose device, available items:");
        Menu.printDevicesItems();
        int[] massOfItems = {1, 2};
        int deviceType = InputUtils.inputItem(massOfItems);
        System.out.println("Choose device firm, available items:");
        Menu.printFirmsItems();
        int deviceFirm = InputUtils.inputItem(massOfItems);
        double deviceModelNum = 0.0;
        if (deviceType == 1) {
            System.out.println("Input notebook model number");
            deviceModelNum = InputUtils.inputModelNum();
        }

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