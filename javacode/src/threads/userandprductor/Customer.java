package threads.userandprductor;

public class Customer implements Runnable {
    private Box box = null;

    public Customer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true) {
            box.get();
        }
    }
}
