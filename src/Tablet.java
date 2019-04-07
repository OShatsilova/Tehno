public class Tablet extends AbstractDevice<Tablet> {
    public Tablet() {
        super.setDeviceType(DeviceType.TABLET);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString()).append("}");
        return str.toString();
    }

    public void touchScreen() {

        System.out.println("I have touchScreen");
    }


}
