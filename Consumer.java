import java.util.List;

public class Consumer extends Thread {
    private List<Integer> sharedQueue;

    public Consumer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            synchronized (sharedQueue) {
                System.out.println("Consumer");
                while (true) {
                    if (sharedQueue.size() > 0) {
                        int n = sharedQueue.remove(0);
                        System.out.println("Consuming: " + n);
                        sharedQueue.notifyAll();
                    } else {
                        sharedQueue.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
