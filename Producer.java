import java.util.List;
import java.util.Random;

public class Producer extends Thread {
    private List<Integer> sharedQueue;

    public Producer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        Random random = new Random();
        synchronized (sharedQueue) {
            while (true) {
                int n = random.nextInt();
                sharedQueue.add(random  .nextInt());
                System.out.println("Producing: " + n);
                sharedQueue.notify();
                try {
                    sharedQueue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
