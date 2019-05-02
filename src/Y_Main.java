import java.io.IOException;

public class Y_Main {


    public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException {

        IContainer<AbstractDevice> deviceIContainer = new ArrayContainer<>();
        Mutator mutator = new Mutator();


        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    new Menu(deviceIContainer).run();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                System.out.println("Finish Menu");
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    mutator.addRandomDevice(deviceIContainer);
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        Thread t3 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    mutator.deleteRandomDevice(deviceIContainer);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };


        t1.start();
        t2.setDaemon(true);
        t2.start();
        t3.setDaemon(true);
        t3.start();

        //Menu.run();
        //Menu.test();
    }

}
