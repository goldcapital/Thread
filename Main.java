import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter=new Counter();

        MyTread t1 =new MyTread( counter);
        MyTread t2 =new MyTread(counter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getCount());
        List<Integer> sharedQueue = new LinkedList<Integer>(); //Creating shared object
        Producer producer = new Producer(sharedQueue);
        Consumer consumer = new Consumer(sharedQueue);

        producer.start();
        consumer.start();


    }
}
