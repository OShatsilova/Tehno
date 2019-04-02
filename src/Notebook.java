public class Notebook extends AbstractDevice {
    private double deviceModelNumber;

    public Notebook(double modelNum) {
        this.deviceModelNumber = modelNum;
        super.setDeviceType(DeviceType.NOTEBOOK);
    }

    public double getDeviceModelNumber() {
        return deviceModelNumber;
    }

    public void setDeviceModelNumber(double deviceModelNumber) {
        this.deviceModelNumber = deviceModelNumber;
    }

    public void openCD() {
        System.out.println(super.getDeviceFirm() + " notebook CD is opened");
    }

    public void closeCD() {
        System.out.println(super.getDeviceFirm() + " notebook CD is closed");
    }

    @Override
    public String toString() {
        return super.toString() + deviceModelNumber;
    }

    @Override
    public boolean equals(Object obj) {

        Notebook notebook = (Notebook) obj;
        return super.equals(obj)
                && deviceModelNumber == notebook.deviceModelNumber;
    }
}
