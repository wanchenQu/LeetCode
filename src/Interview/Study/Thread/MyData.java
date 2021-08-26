package Interview.Study.Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class MyData {
    //int number = 0;
    volatile int number = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public void addTo60() {
        this.number = 60;
    }

    public void addPlusPlus() {
        number++;
    }

    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}
