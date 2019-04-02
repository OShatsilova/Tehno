public class Tablet extends AbstractDevice<Tablet> {
   public Tablet() {
        super.setDeviceType(DeviceType.TABLET);
    }

    public void touchScreen() {

        System.out.println("I have touchScreen");
    }


}
