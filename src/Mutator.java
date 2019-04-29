import java.util.Random;

/**
 * Created by EGAR on 25.04.2019.
 */
public class Mutator {

    public void addRandomDevice(IContainer deviceIContainer) {
        AbstractDevice device = new AbstractDevice();
        switch (1 + (int) (Math.random() * 2)) {
            case 1: {
                device = new Notebook(Math.round((1 + Math.random() * 2) * 100) / 100);
                break;
            }
            case 2: {
                device = new Tablet();
                break;
            }
        }
        switch (1 + (int) (Math.random() * 2)) {
            case 1:
                device.setDeviceFirm(Firms.ASUS);
                break;
            case 2: {
                device.setDeviceFirm(Firms.DELL);
                break;
            }
        }
        deviceIContainer.add(device);
    }

    public void deleteRandomDevice(IContainer deviceIContainer) {
        if (deviceIContainer.size() != 0) {
            int index = (int) (Math.random() * deviceIContainer.size());
            deviceIContainer.delete(index);
        }
    }
}
