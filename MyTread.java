public class MyTread extends  Thread{
    private  Counter counter;
    public MyTread(Counter counter) {

        this.counter=counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
           // synchronized (counter) {
             //   counter.setCount(counter.getCount() + 1);

            }

        }
    }
}
