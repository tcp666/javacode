package threads.userandprductor;

public class Produce implements Runnable {
    private Box box = null;

    public Produce(Box box) {
        this.box = box;
    }


    @Override
    public void run() {
        for (int i=0;i<5;i++){
            box.put(i);
        }

    }
}
