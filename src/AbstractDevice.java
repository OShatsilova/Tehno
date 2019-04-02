public class AbstractDevice<T extends AbstractDevice<T>> {
    private DeviceType deviceType;
    private Firms deviceFirm;
    private String deviceState;


    public AbstractDevice() {
        this.deviceState = "OFF";
    }

    public void turnON() {
        this.deviceState = "ON";
        System.out.println("Power ON");
    }

    public void turnOFF() {
        this.deviceState = "OFF";
        System.out.println("Power OFF");
    }

    public Firms getDeviceFirm() {
        return deviceFirm;
    }

    public void setDeviceFirm(Firms deviceFirm) {
        this.deviceFirm = deviceFirm;
    }

    public String getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(String deviceState) {
        this.deviceState = deviceState;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public AbstractDevice getDevice(){
        return this;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str = str.append(deviceFirm).append(" ").append(deviceType).append(" ");
        return str.toString();

    }

    @Override
    public boolean equals(Object obj) {

        // If the object is compared with itself then return true
        if (obj == this) {
            return true;
        }

        //Check if obj is an instance of AbstractDevice returns false
        if (!(obj instanceof AbstractDevice)) {
            return false;
        }

        // typecast obj to Film so that we can compare data members
        AbstractDevice device = (AbstractDevice) obj;

        // Compare the data members and return accordingly
        return deviceType.equals(device.deviceType)
                && deviceFirm.equals(device.deviceFirm);
    }

}
